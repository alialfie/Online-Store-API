package com.example.onlinestore.UserManagment.Web;

import com.example.onlinestore.UserManagment.Model.LoggedUser;
import com.example.onlinestore.UserManagment.Model.User;
import com.example.onlinestore.UserManagment.Repository.UserRepository;
import com.example.onlinestore.UserManagment.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/user") // This means URL's start with /demo (after Application path)

public class UserResource {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @PostMapping(path = "/add") // Map ONLY POST Requests
    public @ResponseBody
    String add(@RequestParam String username, @RequestParam String password , @RequestParam String email,@RequestParam String name,
             @RequestParam String age, @RequestParam int type,  String address, String addedByUsername, String addedByPassword)
    {
        return userService.addUser(username, password, email, name, age, type, address, addedByUsername, addedByPassword);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userService.getAllUsers();
    }
/*
    @GetMapping(path="/test")
    public @ResponseBody Iterable<User> GetUsers() {
        // This returns a JSON or XML with the users
        return userService.getAllUsers22();
    }
*/
    @PostMapping(path = "/login")
    public @ResponseBody String login(@RequestParam String user, @RequestParam String password){
        return userService.login(user, password);
    }
    @GetMapping(path = "/loggeduser")
    public @ResponseBody User loged(){
        return LoggedUser.getUser();
    }
    @GetMapping(path="/logout")
    public @ResponseBody String logout() {
        return userService.logout();
    }
}
