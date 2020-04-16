package com.example.onlinestore;

import com.example.onlinestore.UserManagment.RepositoryTests.UserRepositoryTests;
import com.example.onlinestore.UserManagment.ServiceTests.UserServiceTests;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UserRepositoryTests.class,
        UserServiceTests.class
})
public class OnlinestoreApplicationTests {
}
