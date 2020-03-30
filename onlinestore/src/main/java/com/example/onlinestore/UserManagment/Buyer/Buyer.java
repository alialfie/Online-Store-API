package com.example.onlinestore.UserManagment.Buyer;

import com.example.onlinestore.UserManagment.User.User;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Buyer extends User
{
    @Size(min = 1)
    private String adrress;

    public String getAdrress() {
            return adrress;
    }

    public void setAdrress( String adrress) {
        this.adrress = adrress;
    }
}
