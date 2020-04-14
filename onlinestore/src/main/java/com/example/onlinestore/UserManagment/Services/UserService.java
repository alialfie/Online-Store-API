package com.example.onlinestore.UserManagment.Services;

import com.example.onlinestore.UserManagment.Model.Admin;
import com.example.onlinestore.UserManagment.Repository.AdminRepository;
import com.example.onlinestore.UserManagment.Model.Buyer;
import com.example.onlinestore.UserManagment.Repository.BuyerRepository;
import com.example.onlinestore.UserManagment.Model.LoggedUser;
import com.example.onlinestore.UserManagment.Model.User;
import com.example.onlinestore.UserManagment.Model.StoreOwner;
import com.example.onlinestore.UserManagment.Repository.StoreOwnerRepository;
import com.example.onlinestore.UserManagment.Repository.UserRepository;
import com.example.onlinestore.UserManagment.Validator.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        Validation validate = new Validation();

        if(!validate.validUsername(username)) return "This username is invalid or already taken";

        if(!validate.validEmail(email)) return "This email is invalid or already registered";

        if(!validate.validPassword(password)) return "Invalid password";

        switch (type) {
            case 1:
                Buyer buyer = new Buyer();

                buyer.setName(name);
                buyer.setEmail(email);
                buyer.setPassword(password);
                buyer.setUsername(username);
                buyer.setAge(age);
                buyer.setAdrress(address);
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
        if((LoggedUser.getUser() instanceof Admin)) {
            return userRepository.findAll();
        }
        else {
            ArrayList<User> tmp = new ArrayList<>();
            return tmp;
        }
    }
/*
    public Iterable<User> getAllUsers22()
    {
           if((LoggedUser.getUser() instanceof Admin)) {
               return userRepository.findAll();
        }
        else {
            ArrayList<User> tmp = new ArrayList<>();
            return tmp;
        }
   }
*/
    public String login(String username,String password){
        if(LoggedUser.getUser() == null) {
            //Validation validate = new Validation();
            User user = validLogin(username, password);
            if (user == null)
                return "Invalid username/email or password";
            else {
                LoggedUser.setUser(user);
                return "Welcome Back!";
            }
        }
        else
            return "You Are Already Logged In, " + LoggedUser.loggedUser.getName();
    }

    public String logout(){
        User user = LoggedUser.getUser();

        if(user == null) return "You Cant Access This Page, Please Log-in";
        else {
            LoggedUser.setUser(null);
            return "See You Soon!";
        }
    }

    User validLogin(String username, String password){
        for (User user : getAllUsers()){
            //todo handle the email thingy again 3lashan el findByID!!!
            if( (user.getUsername().equals(username)||user.getEmail().equals(username)) && user.getPassword().equals(password)){
                Optional<Admin> isAdmin = adminRepository.findById(username);
                Optional<Buyer> isBuyer = buyerRepository.findById(username);
                Optional<StoreOwner> isStoreOwner = storeownerRepository.findById(username);
                if(isAdmin.isPresent()) {
                    Admin admin2;
                    admin2 = isAdmin.get();
                    System.out.println("its an admin");
                    return admin2;
                }
                else if (isBuyer.isPresent()) {
                    Buyer UserBuyer;
                    UserBuyer = isBuyer.get();
                    System.out.println("its a buyer");
                    return UserBuyer;
                }
                else if(isStoreOwner.isPresent()) {
                    StoreOwner UserOwner;
                    UserOwner = isStoreOwner.get();
                    System.out.println("its a store owner");
                    return UserOwner;
                }
            }
        }
        return null;
    }
}
