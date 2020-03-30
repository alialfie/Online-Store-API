package com.example.onlinestore.UserManagment.Buyer;

import com.example.onlinestore.UserManagment.User.user;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Buyer extends user
{
    @NotNull
    private String adrress;

    public String getAdrress() {
            return adrress;
    }

    public void setAdrress( String adrress) {
        this.adrress = adrress;
    }
}
