package com.microservices.users.logic.loginSession.service;

import com.microservices.shared_utils.statusResponces.StatusResponse;
import com.microservices.users.commons.SequenceGeneratorService;
import com.microservices.users.logic.loginSession.entity.LoginSessions;
import com.microservices.users.logic.loginSession.repository.LoginSessionRepository;
import com.microservices.users.modelResponse.LoginSessionListResponse;
import com.microservices.users.modelResponse.LoginSessionsMongoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginSessionCRUDOps {

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    private LoginSessionRepository loginSessionRepository;

    public StatusResponse saveLoginSession(LoginSessions loginSessions) {
        if (loginSessions.getId() == null || !loginSessionRepository.existsById(loginSessions.getId())) {
            loginSessions.setId(sequenceGeneratorService.getSequenceNumber(LoginSessions.SEQUENCE_LOGIN_SESSIONS));
        }

        if (loginSessions.getUserEmail() == null
                || loginSessions.getLoginTime() == null
                || loginSessions.getAuthToken() == null
                || loginSessions.getTokenExpiry() == null
                || loginSessions.getActive() == null
        ) return new StatusResponse(
                false,
                "Some Fields are missing"
        );

        return new StatusResponse(
                true,
                "Login Session saved successfully",
                loginSessionRepository.save(loginSessions)
        );
    }

    public LoginSessionListResponse getAllLoginSessions(String email, Integer page, Integer size) {
        LoginSessionsMongoResponse response = loginSessionRepository.getAllWithPagination(email, page, size);

        if (response.getData().isEmpty())
            return new LoginSessionListResponse(
                    false,
                    "Login Sessions Not Exist"
            );

        return new LoginSessionListResponse(
                true,
                "Login Session Retrieved Successfully",
                response.getTotalCount(),
                response.getData()
        );
    }
}
