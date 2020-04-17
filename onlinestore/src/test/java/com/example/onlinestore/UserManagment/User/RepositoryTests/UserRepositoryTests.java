package com.example.onlinestore.UserManagment.RepositoryTests;

import com.example.onlinestore.OnlinestoreApplication;
import com.example.onlinestore.UserManagment.Model.Buyer;
import com.example.onlinestore.UserManagment.Model.User;
import com.example.onlinestore.UserManagment.Repository.BuyerRepository;
import com.example.onlinestore.UserManagment.Repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OnlinestoreApplication.class)
@Transactional
public class UserRepositoryTests {
    @Autowired
    private BuyerRepository buyerRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void whenFindByUsernameOrEmail_thenReturnUser(){
        //given
        Buyer buyer = new Buyer("testusername", "testpassword", "testemail@email.com", "testname",
                "testage", "testaddress");

        buyerRepository.save(buyer);

        //when
        List<User> found = userRepository.findByUsernameOrEmail("testusername", "testemail@email.com");

        //then
        assertEquals(found.size(), 1);
        assertEquals(found.get(0).getUsername(), buyer.getUsername());
        assertEquals(found.get(0).getEmail(), buyer.getEmail());
    }
}