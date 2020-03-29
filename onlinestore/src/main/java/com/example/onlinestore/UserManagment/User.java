package com.example.onlinestore.UserManagment;


import com.example.onlinestore.UserManagment.User;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
public abstract class User {
    @Id
    @Size(min = 1)
    private String username;

    @Size(min = 1)
    private String password;
    @Size(min = 1)
    private String email;
    @Size(min = 1)
    private String name;

    @Size(min = 1)
    private String age;

    public String getUsername() { return username; }

    public void setUsername(  String username) {
            this.username = username;
    }

    public String getPassword() {
            return password;
    }

    public String getEmail() {
        return email;
    }
    public void setPassword(String password) {
            this.password = password;
    }

    public void setEmail(String email) {
            this.email = email;
    }
    public void setName(String name) {
            this.name = name;
    }
    public String getName() {
            return name;
    }

    public String getAge() {
            return age;
    }

    public void setAge(String age) {
            this.age = age;
    }
}
