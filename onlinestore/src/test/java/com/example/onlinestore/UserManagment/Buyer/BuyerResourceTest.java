package com.example.onlinestore.UserManagment.Buyer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuyerResourceTest {

    @Test
    void addNewUser() {
        BuyerResource buyer = new BuyerResource();
        String myResp = buyer.addNewUser("itsMe", "my@email",
                "myPass", "myUsername", 20,"there" );
        assertEquals("Saved", myResp);
    }
}