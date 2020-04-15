# Online Store Api

# overview
this program is an api for an online store that will help developers create online stores easily by using the functionalities inside our api.

# Prerequisites
Must have MySql installed on your system in order to use the database

# functionalities
Register
    
    //url for admin registration
    "http://localhost:8080/user/add?username=seaweed&password=12345678&email=salmaaaa@yahoo.com&name=salma&age=21&addedByUsername=alienska&addedByPassword=0987654321&type=2"
    takes the user's input from the url like username,email,password,age,name,address and another admin's username and 
    password when needed in order to be able to register as an admin. 
    
    //url for buyer registration
    "http://localhost:8080/user/add?username=Yoiash&password=12345678&email=mix@yahoo.com&name=Youssef&age=21&address=october&type=1"
    Users can also register as a buyers ,
    
    //url for store owner registration
    "http://localhost:8080/user/add?username=BOI&password=12345678&email=BOIS@yahoo.com&name=Youssef&age=21&type=3"
    or as store owners.
    
    all users must have usernames passwords and emails which we validate by checking if they are in the correct format.
    if they are already in the database or not so that no two users have the same username.
    we also check if they inserted a username , a password and an email or not because without them no user can register.
    
    
Login
    
    
Logout

Show all users

