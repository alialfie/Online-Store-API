package com.example.onlinestore.UserManagment.User;


import com.example.onlinestore.UserManagment.Admin.Admin;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import javax.validation.constraints.*;

@JsonDeserialize(as = Admin.class)  // JSON cannot deserialize an abstract type, so in order to use an array of User
                                    // when validating, we tell JSON to deserialize as a subclass i.e. Admin

@Entity
public abstract class User {
    @Id
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String email;

    @NotNull
    private String name;

    @NotNull
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
