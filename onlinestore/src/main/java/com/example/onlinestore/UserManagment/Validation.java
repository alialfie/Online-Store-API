package com.example.onlinestore.UserManagment;

import com.example.onlinestore.UserManagment.User.user;
import com.example.onlinestore.UserManagment.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class Validation
{

    static List<user> users;
    @Autowired
    UserRepository userRepository;
    public Validation()
    {
            Iterable<user> it = userRepository.findAll();
            users = new ArrayList<user>();
            for (Object user : it)
            {
                System.out.println(user);
                users.add((com.example.onlinestore.UserManagment.User.user)user);
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
