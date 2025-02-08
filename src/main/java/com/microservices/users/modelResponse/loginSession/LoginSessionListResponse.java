package com.microservices.users.modelResponse.loginSession;

import com.microservices.users.logic.loginSession.entity.LoginSessions;

import java.util.List;

public class LoginSessionListResponse {
    public Boolean success;
    public String message;
    public Long totalCount;
    public List<LoginSessions> data;

    public LoginSessionListResponse() {
    }

    public LoginSessionListResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public LoginSessionListResponse(Boolean success, String message, Long totalCount, List<LoginSessions> data) {
        this.success = success;
        this.message = message;
        this.totalCount = totalCount;
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public List<LoginSessions> getData() {
        return data;
    }

    public void setData(List<LoginSessions> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "LoginSessionListResponse{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", totalCount=" + totalCount +
                ", data=" + data +
                '}';
    }
}
