package com.example.onlinestore.UserManagment.Service;

import com.example.onlinestore.UserManagment.Model.Admin;
import com.example.onlinestore.UserManagment.Repository.AdminRepository;
import com.example.onlinestore.UserManagment.Model.Buyer;
import com.example.onlinestore.UserManagment.Repository.BuyerRepository;
import com.example.onlinestore.UserManagment.LoggedUser;
import com.example.onlinestore.UserManagment.Model.User;
import com.example.onlinestore.UserManagment.Model.StoreOwner;
import com.example.onlinestore.UserManagment.Repository.StoreOwnerRepository;
import com.example.onlinestore.UserManagment.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BuyerRepository buyerRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private StoreOwnerRepository storeownerRepository;

    public String addUser(String username, String password , String email, String name,
                          String age, int type, String address, String addedByUsername,
                          String addedByPassword){

        switch (type) {
            case 1:
                Buyer buyer = new Buyer();

                buyer.setName(name);
                buyer.setEmail(email);
                buyer.setPassword(password);
                buyer.setUsername(username);
                buyer.setAge(age);
                buyer.setAddress(address);
                BuyerService buyerservice = new BuyerService();
                if(!buyerservice.checkValidation(address))
                    return "Invalid address";
                else
                    buyerRepository.save(buyer);
                break;
            case 2:
                Optional<Admin> adminOp = adminRepository.findById(addedByUsername);
                Admin admin2;
                if(adminOp.isPresent()){
                    admin2 = adminOp.get();
                    if(!admin2.getPassword().equals(addedByPassword)) return "Incorrect admin password";
                }else{
                    return "Admin doesn't exist";
                }

                Admin admin = new Admin();
                admin.setName(name);
                admin.setEmail(email);
                admin.setPassword(password);
                admin.setUsername(username);
                admin.setAge(age);
                admin.setAddedBy(admin2);
                adminRepository.save(admin);
                break;
            case 3:
                StoreOwner storeowner = new StoreOwner();
                storeowner.setName(name);
                storeowner.setEmail(email);
                storeowner.setPassword(password);
                storeowner.setUsername(username);
                storeowner.setAge(age);
                storeownerRepository.save(storeowner);
                break;
        }

        return "Saved";
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public String logout(){
        User user = LoggedUser.getUser();

        if(user == null) return "You Cant Access This Page, Please Log-in";
        else {
            LoggedUser.setUser(null);
            return "See You Soon!";
        }
    }

    public List<User> getByUsernameOrEmail(String username, String email){
        return userRepository.findByUsernameOrEmail(username, email);
    }
}
