package com.example.onlinestore.UserManagment.Repository;

import com.example.onlinestore.UserManagment.Model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,String> {
    List<User> findByUsernameOrEmail(String username, String email);
}
