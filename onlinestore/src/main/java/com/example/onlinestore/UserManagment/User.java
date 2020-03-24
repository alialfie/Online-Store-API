package com.example.onlinestore.UserManagment;


import com.example.onlinestore.UserManagment.User;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
public abstract class User {
    @Id
    @NotNull
    @NotEmpty
    @NotBlank
    private String username;

    @NotNull
    @NotEmpty
    @NotBlank
    private String password;

    @NotNull
    @NotEmpty
    @NotBlank
    private String email;

    @NotNull
    @NotEmpty
    @NotBlank
    private String name;

    @NotNull
    @NotEmpty
    @NotBlank
    private String age;

    public String getUsername() { return username; }

    public void setUsername(  String username) {
        if(username.equals("null") || username.equals("Null") || username.length()==0) {
            this.username=null;
        }
        else
        {
            this.username = username;
        }
    }

    public String getPassword() {
            return password;
    }

    public String getEmail() {
        return email;
    }
    public void setPassword(String password) {
        if(password.equals("null") || password.equals("Null") || password.length()==0) {
            this.password=null;
        }
        else {
            this.password = password;
        }
    }

    public void setEmail(String email) {
        if(email.equals("null") || email.equals("Null") || email.length()==0) {
            this.email=null;
        }
        else {
            this.email = email;
        }
    }
    public void setName(String name) {
        if(name.equals("null") || name.equals("Null") || name.length()==0) {
            this.name=null;
        }
        else {
            this.name = name;
        }

    }
    public String getName() {
            return name;
    }


    public String getAge() {
            return age;
    }

    public void setAge(String age) {
        if(age.equals("null") || age.equals("Null") || age.length()==0) {
            this.age=null;
        }
        else {
            this.age = age;
        }

    }
}
