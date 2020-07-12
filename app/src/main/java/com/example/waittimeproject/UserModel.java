package com.example.waittimeproject;

public class UserModel {
    public String uid;
    public String userName;
    public String phone;
    public String password;
    public UserModel(){

    }
    public UserModel(String uid, String userName,String phone,String password){
        this.uid = uid;
        this.userName = userName;
        this.phone = phone;
        this.password = password;
    }

    public String getUid() {
        return uid;
    }

    public String getPhone(){
        return phone;
    }
    public String getPassword(){
        return password;
    }
    public String getUserName() {
        return userName;
    }

    
}
