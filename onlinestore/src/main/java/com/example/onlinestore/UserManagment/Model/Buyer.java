package com.example.onlinestore.UserManagment.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Buyer extends User
{
    @NotNull
    private String address;

    public Buyer() {
    }

    public Buyer(String username, @NotNull String password, @NotNull String email, @NotNull String name, @NotNull String age, @NotNull String address) {
        super(username, password, email, name, age);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}