package com.example.onlinestore.UserManagment.Validator;


import com.example.onlinestore.UserManagment.Model.Admin;
import com.example.onlinestore.UserManagment.Model.User;
import com.example.onlinestore.UserManagment.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Component
public class UserValidator {
//    private final RestTemplate restTemplate;
//    private RestTemplateBuilder restTemplateBuilder;
//    User[] users;

    @Autowired
    private UserService userService;

    private Iterable<User> users;

//    public UserValidator(){
//        restTemplateBuilder = new RestTemplateBuilder();
//
//        this.restTemplate = restTemplateBuilder.build();
//
//        String url = "http://localhost:8080/user/all/";
//        ResponseEntity<User[]> response = this.restTemplate.getForEntity(url, User[].class);
//
//        users = response.getBody();
//    }

    public String validate(String username, String email, String password){
        users = userService.getAllUsers();
        if(!validUsername(username)) return "This username is invalid or already taken";

        if(!validEmail(email)) return "This email is invalid or already registered";

        if(!validPassword(password)) return "Invalid password";

        return "valid";
    }

    public User login(String id, String password){
        List<User> users = userService.getByUsernameOrEmail(id, id);

        if(users.size() == 1){
            User user = users.get(0);
            if(user.getPassword().equals(password)){
                return user;
            }
        }

        return null;
    }

    private boolean validUsername(String username){

        if(username == null || username.length() < 6) return false;

        for(User user: users){
            if(username.equals(user.getUsername())){
                return false;
            }
        }

        return true;
    }

    private boolean validEmail(String email){
        Pattern rfc2822 = Pattern.compile(
                "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$"
        );

        if (!rfc2822.matcher(email).matches()) return false;

        for(User user: users){
            if(email.equals(user.getEmail())){
                return false;
            }
        }

        return true;
    }

    private boolean validPassword(String password){
        if(password.length() < 8) return false;

        return true;
    }

    /*public User validLogin(String username, String password){
        for (User user : users){
            if( (user.getUsername().equals(username)||user.getEmail().equals(username)) && user.getPassword().equals(password)){
                Optional<Admin> isAdmin = adminRepository.findById(username);
                Optional<Buyer> isBuyer = buyerRepository.findById(username);
                Optional<StoreOwner> isStoreOwner = storeownerRepository.findById(username);
                if(isAdmin.isPresent()) {
                    Admin admin2;
                    admin2 = isAdmin.get();
                    System.out.println("its an admin");
                    return admin2;
                }
                else if (isBuyer.isPresent()) {
                    Buyer UserBuyer;
                    UserBuyer = isBuyer.get();
                    System.out.println("its a buyer");
                    return UserBuyer;
                }
                else if(isStoreOwner.isPresent()) {
                    StoreOwner UserOwner;
                    UserOwner = isStoreOwner.get();
                    System.out.println("its a store owner");
                    return UserOwner;
                }
                //return user;
            }
        }
        return null;
    }*/
}