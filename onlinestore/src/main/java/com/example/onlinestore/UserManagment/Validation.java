package com.example.onlinestore.UserManagment;

import com.example.onlinestore.UserManagment.Buyer.Buyer;
import com.example.onlinestore.UserManagment.User.User;
import com.example.onlinestore.UserManagment.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Validation {
    private final RestTemplate restTemplate;
    private RestTemplateBuilder restTemplateBuilder;

    User[] users;

    public  Validation(){
        restTemplateBuilder = new RestTemplateBuilder();

        this.restTemplate = restTemplateBuilder.build();

        String url = "http://localhost:8080/user/all/";
        ResponseEntity<User[]> response = this.restTemplate.getForEntity(url, User[].class);

        users = response.getBody();
    }

    public boolean validUsername(String username){
        if(username == null || username.length() < 6) return false;

        for(int i=0; i<users.length; i++){
            if(username.equals(users[i].getUsername())){
                return false;
            }
        }

        return true;
    }

    public boolean validEmail(String email){
        Pattern rfc2822 = Pattern.compile(
                "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$"
        );

        if (!rfc2822.matcher(email).matches()) return false;

        for(int i=0; i<users.length; i++){
            if(email.equals(users[i].getEmail())){
                return false;
            }
        }

        return true;
    }

    public boolean validPassword(String password){
        if(password.length() < 8) return false;

        return true;
    }
}