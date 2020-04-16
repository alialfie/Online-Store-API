package com.example.onlinestore.UserManagment.Resource;

import com.example.onlinestore.UserManagment.Model.Admin;
import com.example.onlinestore.UserManagment.LoggedUser;
import com.example.onlinestore.UserManagment.Model.User;
import com.example.onlinestore.UserManagment.Service.UserService;
import com.example.onlinestore.UserManagment.Validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/user") // This means URL's start with /demo (after Application path)

public class UserResource {
    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @PostMapping(path = "/add") // Map ONLY POST Requests
    public @ResponseBody
    String add(@RequestParam String username, @RequestParam String password , @RequestParam String email,@RequestParam String name,
             @RequestParam String age, @RequestParam int type,  String address, String addedByUsername, String addedByPassword)
    {
        String valid = userValidator.validate(username, email, password);

        if(valid.equals("valid")) {
            return userService.addUser(username, password, email, name, age, type, address, addedByUsername, addedByPassword);
        }else{
            return valid;
        }
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        if((LoggedUser.getUser() instanceof Admin)) {
            return userService.getAllUsers();
        } else {
            ArrayList<User> tmp = new ArrayList<>();
            return tmp;
        }
    }

    @PostMapping(path = "/login")
    public @ResponseBody String login(@RequestParam String user, @RequestParam String password){
        if(LoggedUser.getUser() == null) {
            User loggedUser = userValidator.login(user, password);
            LoggedUser.setUser(loggedUser);
            if (loggedUser == null)
                return "Invalid username/email or password";
            else {
                return "Welcome Back!";
            }
        }else{
            return "You Are Already Logged In, " + LoggedUser.loggedUser.getName();
        }
//        return userService.login(user, password);
    }

    @GetMapping(path="/logout")
    public @ResponseBody String logout() {
        return userService.logout();
    }
}
