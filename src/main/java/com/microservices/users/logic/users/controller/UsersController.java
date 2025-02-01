package com.microservices.users.logic.users.controller;

import com.microservices.shared_utils.statusResponces.StatusResponse;
import com.microservices.users.logic.users.entity.Users;
import com.microservices.users.logic.users.service.UserCRUDOps;
import com.microservices.users.logic.users.service.UserLoginService;
import com.microservices.users.modelRequest.LoginVerificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserCRUDOps userCRUDOps;

    @Autowired
    private UserLoginService userLoginService;

    @PostMapping("/register")
    public StatusResponse createUser(@RequestBody Users users) {
        return userCRUDOps.createUser(users);
    }

    @PostMapping("/login")
    public StatusResponse loginUser(@RequestBody LoginVerificationRequest loginVerificationRequest) {
        return userLoginService.loginUser(loginVerificationRequest);
    }

}
