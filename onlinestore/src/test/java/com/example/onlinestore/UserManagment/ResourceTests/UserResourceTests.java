package com.example.onlinestore.UserManagment.ResourceTests;

import com.example.onlinestore.OnlinestoreApplication;
import com.example.onlinestore.UserManagment.LoggedUser;
import com.example.onlinestore.UserManagment.Model.Admin;
import com.example.onlinestore.UserManagment.Model.Buyer;
import com.example.onlinestore.UserManagment.Model.User;
import com.example.onlinestore.UserManagment.Resource.UserResource;
import com.example.onlinestore.UserManagment.Service.UserService;
import com.example.onlinestore.UserManagment.Validator.UserValidator;
import com.mysql.cj.log.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = OnlinestoreApplication.class)
@WebMvcTest(UserResource.class)
public class UserResourceTests {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService service;

    @MockBean
    private UserValidator userValidator;

    @Test
    public void givenUsers_whenGetAllUsers_thenReturnJsonArray()
            throws Exception {

        Buyer buyer = new Buyer("testusername", "testpassword", "testemail@email.com", "testname",
                "testage", "testaddress");

        List<User> allUsers = Arrays.asList(buyer);

        when(service.getAllUsers()).thenReturn(allUsers);

        Admin admin = new Admin();
        LoggedUser.setUser(admin);

        mvc.perform(get("/user/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].username", is(buyer.getUsername())));

        LoggedUser.setUser(null);
        mvc.perform(get("/user/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }
}
