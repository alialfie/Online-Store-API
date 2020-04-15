# Online Store Api

# overview
this program is an api for an online store that will help developers create online stores easily by using the functionalities inside our api.

# Prerequisites
Must have MySql installed on your system in order to use the database

# functionalities
## Register ##

takes the user's input from the url like username,email,password,age,name,address and another admin's username and 
password when needed in order to be able to register as an admin.  
        
        //url for admin registration
        "http://localhost:8080/user/add?    username=seaweed&password=12345678&email=salmaaaa@yahoo.com&name=salma&age=21&addedByUsername=alienska&addedByPassword=0987654321&type=2    "
Users can also register as a buyers ,

    //url for buyer registration
    "http://localhost:8080/user/add?username=Yoiash&password=12345678&email=mix@yahoo.com&name=Youssef&age=21&address=october&type=1"
    
 or as store owners.
 
    //url for store owner registration
    "http://localhost:8080/user/add?username=BOI&password=12345678&email=BOIS@yahoo.com&name=Youssef&age=21&type=3"
   
    
    
## Login ##

 takes input from user in the form of a url it takes username and password or email and password to allow an already registered
 user to log into the website and use the functionalities associated with its type. 

    
## Logout ##
    
  a user is logged out from the system and another user can login
    
## Show all users ##

  can only be used while logged in and only when the user is an admin it shows all the users in the system.
    
# used framework
we used springboot framework in order to build our online store api

# included libraries
* java.util.List
    * used to store user info during runtime and returning or printing it.
* java.util.regex.Pattern
    * used for defining text patterns used in UserValidator class.
* javax.persistence.Entity 
    * to define an entity in the database

* javax.persistence.JoinColumn 
    * to join columns for referencing and entity association.

* javax.persistence.ManyToOne
    * to make all admins have a reference to the admin that added them.

* javax.validation.constraints.NotNull 
    * to put a constraint on one of the attributes so that the user has to enter it.

* org.springframework.data.repository.CrudRepository 
    * Interface for generic CRUD operations on a repository for a specific type. we use some of its functions to manipulate our data.

* org.springframework.stereotype.Service 
    * Indicates that an annotated class is a "Service" by using @service annotation

* org.springframework.web.bind.annotation.* 
    * used for implementing web annotations such as @PostMapping and @GetMapping

* org.springframework.stereotype.Controller 
    * Indicates that an annotated class is a "Controller"

