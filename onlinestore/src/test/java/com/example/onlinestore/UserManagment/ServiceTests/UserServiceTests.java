package com.example.onlinestore.UserManagment.ServiceTests;

import com.example.onlinestore.OnlinestoreApplication;
import com.example.onlinestore.UserManagment.LoggedUser;
import com.example.onlinestore.UserManagment.Model.Buyer;
import com.example.onlinestore.UserManagment.Model.User;
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
}