package com.example.onlinestore.UserManagment.Buyer;

import com.example.onlinestore.UserManagment.User;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
public class Buyer extends User
{
    @NotNull
    @NotEmpty
    @NotBlank
    private String adrress;

    public String getAdrress() {
            return adrress;
    }

    public void setAdrress( String adrress) {
        if(adrress.equals("null") || adrress.equals("Null") || adrress.equals("") || adrress.equals(" ")||adrress.length()==0) {
            this.adrress=null;
        }
        else
        {
            this.adrress = adrress;
        }

    }
}
