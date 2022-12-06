package com.example.long3.Model;

import javax.persistence.*;

@Entity
@Table(name = "member")
public class User {
    @Id
    @Column(name = "memberID")
    private String memberID ;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "userName")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "description")
    private String description;
    @Column(name = "createdDate")
    private String createdDate;
    @Column(name = "updateTime")
    private String updateTime;

    public User() {

    }

    public User(String memberID, String firstName, String lastName, String userName, String password, String phone, String email, String description, String createdDate, String updateTime) {
        this.memberID = memberID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.description = description;
        this.createdDate = createdDate;
        this.updateTime = updateTime;
    }

    public User(String memberID, String userName, String password, String email, String createdDate, String updateTime) {
        this.memberID = memberID;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.createdDate = createdDate;
        this.updateTime = updateTime;
    }

    public User(String firstName, String lastName, String phone, String email, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.description = description;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateDate() {
        return createdDate;
    }

    public void setCreateDate(String createDate) {
        this.createdDate = createDate;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "memberID='" + memberID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
