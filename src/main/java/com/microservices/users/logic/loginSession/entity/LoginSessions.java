package com.microservices.users.logic.loginSession.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "user_login_sessions")
public class LoginSessions {

    @Transient
    public static String SEQUENCE_LOGIN_SESSIONS = "user_login_sessions";

    @Id
    public Long id;
    public String userEmail;
    public Date loginTime;
    public String authToken;
    public Date tokenExpiry;
    public Boolean isActive;

    public LoginSessions() {
    }

    public LoginSessions(String userEmail, Date loginTime, String authToken, Date tokenExpiry, Boolean isActive) {
        this.userEmail = userEmail;
        this.loginTime = loginTime;
        this.authToken = authToken;
        this.tokenExpiry = tokenExpiry;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public Date getTokenExpiry() {
        return tokenExpiry;
    }

    public void setTokenExpiry(Date tokenExpiry) {
        this.tokenExpiry = tokenExpiry;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "LoginSessions{" +
                "id=" + id +
                ", userEmail='" + userEmail + '\'' +
                ", loginTime=" + loginTime +
                ", authToken='" + authToken + '\'' +
                ", tokenExpiry=" + tokenExpiry +
                ", isActive=" + isActive +
                '}';
    }
}
