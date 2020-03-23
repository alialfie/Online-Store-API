package com.example.onlinestore.UserManagment;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(  String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
