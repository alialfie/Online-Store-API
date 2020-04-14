package com.example.onlinestore.UserManagment.Validator;


import com.example.onlinestore.UserManagment.Model.User;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
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