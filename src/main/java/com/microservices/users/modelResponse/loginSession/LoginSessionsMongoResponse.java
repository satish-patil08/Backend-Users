package com.microservices.users.modelResponse.loginSession;

import com.microservices.users.logic.loginSession.entity.LoginSessions;

import java.util.List;

public class LoginSessionsMongoResponse {
    public List<LoginSessions> data;
    public Long totalCount;

    public LoginSessionsMongoResponse() {
    }

    public LoginSessionsMongoResponse(List<LoginSessions> data, Long totalCount) {
        this.data = data;
        this.totalCount = totalCount;
    }

    public List<LoginSessions> getData() {
        return data;
    }

    public void setData(List<LoginSessions> data) {
        this.data = data;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "LoginSessionsMongoResponse{" +
                "data=" + data +
                ", totalCount=" + totalCount +
                '}';
    }
}
