package com.example.tawsilatn.models;

public class UserModel {
    String UserCin;
    String UserName;
    String UserEmail;
    String UserPassword;
    String Uid;

    public UserModel(String uid , String userCin, String userName, String userEmail, String userPassword ) {

        Uid = uid;
        UserCin = userCin;
        UserName = userName;
        UserEmail = userEmail;
        UserPassword = userPassword;

    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }

    public UserModel() {
    }

    public UserModel(String userCin, String userName, String userEmail, String userPassword) {
        UserCin = userCin;
        UserName = userName;
        UserEmail = userEmail;
        UserPassword = userPassword;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }

    public String getUserCin() {
        return UserCin;
    }

    public void setUserCin(String userCin) {
        UserCin = userCin;
    }
}
