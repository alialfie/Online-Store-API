package com.example.onlinestore.UserManagment.User;

import com.example.onlinestore.UserManagment.Validation;
import org.springframework.web.bind.annotation.RequestParam;

public class UserService {

    public boolean checkValidation(String email,  String password,String username)
    {
        Validation validate =new Validation();

        if(validate.validUsername(username) && validate.validPassword(password)&& validate.validEmail(email))
        {
            return true;
        }
        return false;
    }
}
