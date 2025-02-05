package com.microservices.users.logic.loginSession.controller;

import com.microservices.shared_utils.statusResponces.StatusResponse;
import com.microservices.users.logic.loginSession.entity.LoginSessions;
import com.microservices.users.logic.loginSession.service.LoginSessionCRUDOps;
import com.microservices.users.modelResponse.LoginSessionListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users/login-sessions")
public class LoginSessionController {


    @Autowired
    private LoginSessionCRUDOps loginSessionCRUDOps;

    @PostMapping("/save")
    public StatusResponse saveLoginSession(@RequestBody LoginSessions loginSessions) {
        return loginSessionCRUDOps.saveLoginSession(loginSessions);
    }

    @GetMapping("/get-all")
    public LoginSessionListResponse getAllLoginSessions(
            @RequestParam(required = false) String email,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size
    ) {
        return loginSessionCRUDOps.getAllLoginSessions(email, page, size);
    }
}
