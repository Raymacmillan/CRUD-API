package com.example.demo.Controller;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Controller.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> Users() {
        return userRepository.getUsers();
    }

    @GetMapping("/users/{id}")
    public JSONObject getUser(@PathVariable int id) {
        System.out.print(id);
        return userRepository.getUserByID(id);
    }

    @PostMapping("/users")
    public JSONObject createUser(@RequestParam String userName, @RequestParam String password, @RequestParam int id) {
        return userRepository.addUser(new User(userName, password, id));
    }

    @DeleteMapping("/users")
    public JSONArray eraseUsers() {
        return userRepository.deleteUsers();
    }

    @DeleteMapping("/users/{id}")
    public JSONObject deletedUserByID(@PathVariable int id) {
        return userRepository.deleteUserByID(id);
    }

    @PatchMapping("/users/{id}")
    public JSONObject updateUser(@RequestParam(required = false) String username, @RequestParam(required = false)  String password, @PathVariable int id) {
        return userRepository.update(username, password, id);
    }
    
}
