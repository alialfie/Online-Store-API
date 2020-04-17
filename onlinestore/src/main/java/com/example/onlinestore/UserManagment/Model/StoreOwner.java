package com.example.onlinestore.UserManagment.Model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class StoreOwner extends User {
    public StoreOwner() {
    }

    public StoreOwner(String username, @NotNull String password, @NotNull String email, @NotNull String name, @NotNull String age) {
        super(username, password, email, name, age);
    }
}