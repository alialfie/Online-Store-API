package com.example.onlinestore.UserManagment.ServiceTests;

import com.example.onlinestore.OnlinestoreApplication;
import com.example.onlinestore.UserManagment.LoggedUser;
import com.example.onlinestore.UserManagment.Model.Admin;
import com.example.onlinestore.UserManagment.Model.Buyer;
import com.example.onlinestore.UserManagment.Model.StoreOwner;
import com.example.onlinestore.UserManagment.Model.User;
import com.example.onlinestore.UserManagment.Repository.AdminRepository;
import com.example.onlinestore.UserManagment.Repository.BuyerRepository;
import com.example.onlinestore.UserManagment.Repository.StoreOwnerRepository;
import com.example.onlinestore.UserManagment.Repository.UserRepository;
import com.example.onlinestore.UserManagment.Service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OnlinestoreApplication.class)
@Transactional
public class UserServiceTests {

    @TestConfiguration
    static class UserServiceTestContextConfiguration {

        @Bean
        public UserService userService() {
            return new UserService();
        }
    }

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private BuyerRepository buyerRepository;

    @MockBean
    private AdminRepository adminRepository;

    @MockBean
    private StoreOwnerRepository storeOwnerRepository;

    @Before
    public void setUp() {
        Buyer buyer = new Buyer("testusername", "testpassword", "testemail@email.com", "testname",
                "testage", "testaddress");
        List<User> users = new ArrayList<User>();
        users.add(buyer);

        Mockito.when(userRepository.findByUsernameOrEmail("testusername", "testemail@email.com"))
                .thenReturn(users);

    }

    @Test
    public void whenValidUsernameOrEmail_thenUserShouldBeFound() {
        //given
        String username = "testusername";
        String email = "testemail@email.com";

        //when
        List<User> found = userService.getByUsernameOrEmail(username, email);

        //then
        assertEquals(found.size(), 1);
        assertEquals(found.get(0).getUsername(), username);
        assertEquals(found.get(0).getEmail(), email);
    }

    @Test
    public void whenLoggedout_thenLoggedUserShouldBeNull(){
        userService.logout();

        assertEquals(LoggedUser.getUser(), null);
    }

    @Test
    public void whenAddUser_thenReturnUser(){
        //given
        String username ="testusername";
        String password ="testpassword";
        String email = "testemail@email.com";
        String name = "testname";
        String age ="testage";
        String address ="testaddress";

        Buyer buyer = new Buyer("testusername", "testpassword", "testemail@email.com", "testname",
                "testage", "testaddress");
        Mockito.when(buyerRepository.save(buyer)).thenReturn(buyer);


        //when
        String buyerSaveTest = userService.addUser(username, password,email,name,age,1,address,"","");

        //then
        assertEquals(buyerSaveTest, "Saved");

        StoreOwner storeOwner = new StoreOwner();
        Mockito.when(storeOwnerRepository.save(storeOwner)).thenReturn(storeOwner);


        //when
        String storeOwnerSaveTest = userService.addUser(username, password,email,name,age,3,"","","");

        //then
        assertEquals(storeOwnerSaveTest, "Saved");



        Admin admin2 = new Admin(username, password,email,name,age,null);


        Mockito.when(adminRepository.save(admin2)).thenReturn(admin2);


        Mockito.when(adminRepository.findById(username)).thenReturn(Optional.of(new Admin(username, password, email, name, age, null)));

        //when
        String adminExistsSaveTest = userService.addUser("Boiois", password,"ash@gmail.com",name,age,2,null,null,null);

        //then
        assertEquals(adminExistsSaveTest, "Admin doesn't exist");

        //when
        String adminPasswordSaveTest = userService.addUser("bakbak", password,"die@gmail.con",name,age,2,null,username,null);

        //then
        assertEquals(adminPasswordSaveTest, "Incorrect admin password");

        String adminAddedSaveTest = userService.addUser("bokbok", password,"hang@gmail.con",name,age,2,null,username,password);

        //then
        assertEquals(adminAddedSaveTest, "Saved");
    }
}