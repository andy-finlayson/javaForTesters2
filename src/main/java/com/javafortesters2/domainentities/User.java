package com.javafortesters2.domainentities;

/**
 * Created by andfin on 03/01/2017.
 */
public class User {
    private final String username;
    private String password;
    public User(){
        username = "username";
        password = "Passw0rd";
    }

    public User(String username,String password)throws InvalidPassword{
        this.username = username;
        setPassword(password);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password)throws InvalidPassword{
        if (password.length()<7){
            throw new InvalidPassword("Password must be longer than 7 characters");
        }
        String mustIncludeADigit = ".*[0-9]+.*";
        if(!password.matches(mustIncludeADigit)){
            throw new InvalidPassword("Password must contain a Digit");
        }
        String mustIncludeAUpperCaseLetter = ".*[A-Z]+.*";
        if(!password.matches(mustIncludeAUpperCaseLetter)){
            throw new InvalidPassword("Password must contain an Uppercase Letter");
        }
        this.password = password;
    }

}
