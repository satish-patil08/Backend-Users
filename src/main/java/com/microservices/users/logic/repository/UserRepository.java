package com.microservices.users.logic.repository;

import com.microservices.users.logic.entity.Users;
import com.microservices.users.logic.repository.customRepo.UsersCustomRepo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<Users, String>, UsersCustomRepo {
}
