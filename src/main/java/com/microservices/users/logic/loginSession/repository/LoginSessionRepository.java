package com.microservices.users.logic.loginSession.repository;

import com.microservices.users.logic.loginSession.entity.LoginSessions;
import com.microservices.users.logic.loginSession.repository.customRepo.LoginSessionCustomRepo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoginSessionRepository extends MongoRepository<LoginSessions, Long>, LoginSessionCustomRepo {
}
