package com.example.onlinestore.UserManagment.Model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Admin extends User {
    @ManyToOne
    @JoinColumn(name = "addedBy", referencedColumnName = "username")
    private Admin addedBy;

    public Admin() {
    }

    public Admin(String username, @NotNull String password, @NotNull String email, @NotNull String name, @NotNull String age, @NotNull Admin addedBy) {
        super(username, password, email, name, age);
        this.addedBy = addedBy;
    }

    public Admin getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(Admin addedBy) {
        this.addedBy = addedBy;
    }
}
