package com.microservices.users.logic.users.repository;

import com.microservices.users.logic.users.entity.Users;
import com.microservices.users.logic.users.repository.customRepo.UsersCustomRepo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<Users, String>, UsersCustomRepo {
}
