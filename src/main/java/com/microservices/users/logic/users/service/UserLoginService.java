package com.microservices.users.logic.users.service;

import com.microservices.shared_utils.jwtUtils.CustomUserDetails;
import com.microservices.shared_utils.jwtUtils.JwtUtils;
import com.microservices.shared_utils.statusResponces.StatusResponse;
import com.microservices.users.logic.loginSession.controller.LoginSessionController;
import com.microservices.users.logic.loginSession.entity.LoginSessions;
import com.microservices.users.logic.users.entity.Users;
import com.microservices.users.logic.users.repository.UserRepository;
import com.microservices.users.modelRequest.LoginVerificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserLoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EncryptingService encryptingService;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private LoginSessionController loginSessionController;

    public StatusResponse loginUser(LoginVerificationRequest loginVerificationRequest) {
        Optional<Users> users = userRepository.findById(loginVerificationRequest.getEmail());
        if (users.isEmpty()) {
            return new StatusResponse(
                    false,
                    "Incorrect Username"
            );
        } else if (!encryptingService.checkEncryption(loginVerificationRequest.getPassword(), users.get().getPassword())) {
            return new StatusResponse(
                    false,
                    "Incorrect Password"
            );
        }
        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(loginVerificationRequest.getEmail());
        Date expiration;
        final String jwt = jwtUtils.generateToken(
                new CustomUserDetails(
                        userDetails.getUsername(),
                        userDetails.getPassword()
                ),
                expiration = new Date(new Date().getTime() + 1000 * 60 * 60 * 24)
        );
        users.get().setAuthToken(jwt);
        users.get().setPassword(null);

        loginSessionController.saveLoginSession(new LoginSessions(
                users.get().getEmail(),
                new Date(),
                users.get().getAuthToken(),
                expiration,
                true
        ));
        return new StatusResponse(
                true,
                "Login Request Succeeded",
                users
        );
    }
}
