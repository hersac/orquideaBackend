package com.hersac.orquidea.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User{

    //Parameters

    @Id
    @Column(name = "userId")
    private Long userId;

    @Column(name = "userName")
    private String userName;

    @Column(name = "userLastName")
    private String userLastName;

    @Column(name = "userBirthday")
    private String userBirthday;

    @Column(name = "userEmail")
    private String userEmail;

    @Column(name = "userPasswd")
    private String userPasswd;

    @Column(name = "userTel")
    private String userTel;

    @Column(name = "userCountry")
    private String userCountry;

    @Column(name = "userState")
    private String userState;

    @Column(name = "userCity")
    private String userCity;

    @Column(name = "userImageProfile")
    private String userImageProfile;


    //Contructors

    public User(){
        super();
    }

    public User(Long userId, String userName, String userLastName, String userBirthday, String userEmail, String userPasswd, String userTel, String userCountry, String userState, String userCity, String userImageProfile){
        super();
        this.userId = userId;
        this.userName = userName;
        this.userBirthday = userBirthday;
        this.userEmail = userEmail;
        this.userPasswd = userPasswd;
        this.userTel = userTel;
        this.userCountry = userCountry;
        this.userState = userState;
        this.userCity = userCity;
        this.userImageProfile = userImageProfile;
    }

    //Methods
    

    

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPasswd() {
        return userPasswd;
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public void setUserCountry(String userCountry) {
        this.userCountry = userCountry;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserImageProfile() {
        return userImageProfile;
    }

    public void setUserImageProfile(String userImageProfile) {
        this.userImageProfile = userImageProfile;
    }
}


