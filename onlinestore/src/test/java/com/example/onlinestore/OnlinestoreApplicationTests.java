package com.example.onlinestore;

import com.example.onlinestore.UserManagment.RepositoryTests.UserRepositoryTests;
import com.example.onlinestore.UserManagment.ResourceTests.UserResourceTests;
import com.example.onlinestore.UserManagment.ServiceTests.UserServiceTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UserRepositoryTests.class,
        UserServiceTests.class,
        UserResourceTests.class
})
public class OnlinestoreApplicationTests {
}