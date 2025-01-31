package com.microservices.users.logic.controller;

import com.microservices.shared_utils.statusResponces.StatusResponse;
import com.microservices.users.logic.entity.Users;
import com.microservices.users.logic.service.UserCRUDOps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserCRUDOps userCRUDOps;


    @PostMapping("/create")
    public StatusResponse createUser(@RequestBody Users users) {
        return userCRUDOps.createUser(users);
    }
}
