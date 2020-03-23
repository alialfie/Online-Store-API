package com.example.onlinestore.UserManagment.StoreOwner;

import com.example.onlinestore.UserManagment.Buyer.BuyerResource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreOwnerResourceTest {

    @Test
    void addNewUser() {
        StoreOwnerResource StoreOwner = new StoreOwnerResource();
        String myResp = StoreOwner.addNewUser("itsMe", "my@email",
                "myPass", "myUsername", 20);
        assertEquals("Saved", myResp);
    }
}