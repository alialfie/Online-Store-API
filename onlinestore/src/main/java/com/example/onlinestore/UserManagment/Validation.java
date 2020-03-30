package com.example.onlinestore.UserManagment;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Validation {
    static List<User> users;
    UserRepository userRepository;

    public Validation(){
        Iterable it = userRepository.findAll();
        users = new ArrayList<User>();
        for (Object user : it) {
            System.out.println(user);
            users.add((User)user);
        }
    }

    public static boolean validUsername(String username){
        if(username == null || username.length() < 6) return false;

        for(int i=0; i<users.size(); i++){
            if(username.equals(users.get(i).getUsername())){
                return false;
            }
        }

        return true;
    }

    public static boolean validEmail(String email){
        Pattern rfc2822 = Pattern.compile(
                "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$"
        );

        if (!rfc2822.matcher(email).matches()) return false;

        for(int i=0; i<users.size(); i++){
            if(email.equals(users.get(i).getEmail())){
                return false;
            }
        }

        return true;
    }

    public static boolean validPassword(String password){
        if(password.length() < 8) return false;

        return true;
    }
}
