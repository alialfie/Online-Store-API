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

    takes input from user in the form of a url it takes username and password or email and password to allow an already registered
    user to log into the website and use the functionalities associated with its type. 
    we check if the username or the email exist in the database or not then
    we also check if the username and the password are actually associated so that no user can enter any password that's in
    the database but only the password associated with their username or their email.
    
    logging in is done by setting the entered user as a logged user in the logged user class.
    
Logout
    
    logout simply sets the the loggeduser in the class of LoggedUser to null to signify that no user is logged in.
    
Show all users

    can only be used while logged in and only when the user is an admin it returns a list of all the users in the systen with all of 
    their information. if the user is not an admin we return an empty list to whoever tried to use that functionality as they are not
    authorized to use it.
    

