package com.example.onlinestore.UserManagment.Repository;

import com.example.onlinestore.UserManagment.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,String> {
}
