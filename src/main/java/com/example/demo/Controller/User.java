package com.example.demo.Controller;
import org.json.*;
import org.json.simple.JSONObject;
import org.springframework.boot.jackson.JsonObjectDeserializer;

import com.fasterxml.jackson.databind.util.JSONPObject;

public class User {
    private String userName = "";
    private String password = "";
    private int userID = -1;

    public User(String userName, String password, int userID) {
        this.userName = userName;
        this.password = password;
        this.userID = userID;
    } 

    public String Username() {
        return userName;
    }

    public void Username(String newUserName) {
        this.userName = newUserName;
    }

    public String Password() {
        return password;
    }

    public void Password(String newPassword) {
        this.password = newPassword;
    }

    public int UserID() {
        return userID;
    }

    public void UserID(int newUserID) {
        this.userID = newUserID;
    }

    public JSONObject toJSON() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username",this.userName);
        jsonObject.put("password",this.password);
        jsonObject.put("userID",this.userID);

       return jsonObject;
    }
}
