package com.example.demo.Controller;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;

@Repository
public class UserRepository {
    List<User> users = new ArrayList<>(
        Arrays.asList(new User("ugr","opopdospdos",5), new User("oep","rywhas",4))
    );

    public JSONArray usersToJSON() {
        JSONArray jsonArray = new JSONArray();

        for(User user: users) {
            jsonArray.add(user.toJSON());
        }
        return jsonArray;
    }

    public JSONArray getUsers() {
        return usersToJSON();
    }

    public JSONObject getUserByID(int userID) {
        User u = null;
        for (User user : users) {
            System.out.print(user);
            if (user.UserID() == userID) {
                u = user;
                break;  // Break out of the loop once the user is found
            }
        }
        if(u == null) {
            return new JSONObject();
        }
        return u.toJSON();
    }

    public JSONObject addUser(User newUser) {
  
        users.add(newUser);
        
        JSONObject userJSON = new JSONObject();
        userJSON.put("message","successful");
        userJSON.put("user",newUser.toJSON());

        return userJSON;
    }


    private JSONArray allUsers = new JSONArray();

    public JSONArray deleteUsers() {
        allUsers = new JSONArray();
        users = new ArrayList<>();
        return allUsers;
    }

    private List<User> newUsers = new ArrayList<>();
    public JSONObject deleteUserByID(int id) {
        JSONObject jsonUser = new JSONObject();
        for(User user : users) {
            if(user.UserID() == id) {
                newUsers = users.stream()
                .filter(u -> u.UserID() != id)
                .toList();
                jsonUser.put("deletedUser",user.toJSON());
                users = newUsers;
            }
        }
        return jsonUser;
    }

    public JSONObject update(String username, String password, int id) {
        for(User user : users) {
            if(user.UserID() == id) {
                if(username != null){
                    user.Username(username);
                }
                if(password != null){
                    user.Password(password);
                }
                return user.toJSON();
            }
            break;

        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message","user not found");
        return jsonObject;
    }
}
