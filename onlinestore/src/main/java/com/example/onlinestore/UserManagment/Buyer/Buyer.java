package com.example.onlinestore.UserManagment.Buyer;

import com.example.onlinestore.UserManagment.User;

import javax.persistence.*;

@Entity
public class Buyer extends User {
    private String adrress;

    public String getAdrress() {
        return adrress;
    }

    public void setAdrress(String adrress) {
        this.adrress = adrress;
    }
}
