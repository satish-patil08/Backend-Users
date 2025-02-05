package com.microservices.users.logic.loginSession.repository.customRepo;

import com.microservices.users.logic.loginSession.entity.LoginSessions;
import com.microservices.users.modelResponse.LoginSessionsMongoResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;

public class LoginSessionCustomRepoImpl implements LoginSessionCustomRepo {
    private final MongoTemplate mongoTemplate;

    public LoginSessionCustomRepoImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public LoginSessionsMongoResponse getAllWithPagination(String email, Integer page, Integer size) {
        Query query = new Query();
        ArrayList<Criteria> criteriaArr = new ArrayList<>();
        if (email != null && !email.isEmpty()) criteriaArr.add(Criteria.where("userEmail").is(email));

        if (!criteriaArr.isEmpty()) query.addCriteria(new Criteria().andOperator(criteriaArr.toArray(new Criteria[0])));

        if (page != null && size != null) query.with(PageRequest.of(page - 1, size));

        return new LoginSessionsMongoResponse(
                mongoTemplate.find(query, LoginSessions.class),
                mongoTemplate.count(query, LoginSessions.class)
        );
    }
}
