package com.microservices.users.logic.loginSession.repository.customRepo;

import com.microservices.users.modelResponse.LoginSessionsMongoResponse;

public interface LoginSessionCustomRepo  {
    LoginSessionsMongoResponse getAllWithPagination(String email, Integer page, Integer size);
}
