package com.microservices.users.logic.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document(collection = "users")
public class Users {


    @Id
    public String email;
    public Date createDateTime;
    public String firstName;
    public String lastName;
    public String fullName;
    public String password;
    public String contactNo;

    public Users() {
    }

    public Users(String email, Date createDateTime, String firstName, String lastName, String fullName, String contactNo, String password) {
        this.email = email;
        this.createDateTime = createDateTime;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.contactNo = contactNo;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "email='" + email + '\'' +
                ", createDateTime=" + createDateTime +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
