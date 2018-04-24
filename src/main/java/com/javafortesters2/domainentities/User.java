package com.javafortesters2.domainentities;

/**
 * Created by andfin on 03/01/2017.
 */
public class User {
    private final String username;
    private String password;
    private String firstName;
    private String lastName;
    private String mobile_number;
    private String emailAddress;


    public User() {
        username = "username";
        password = "Passw0rd";
        firstName = null;
        lastName = null;
        mobile_number = null;
        emailAddress = null;
    }

    public User(String username, String password) throws InvalidPassword {
        this.username = username;
        setPassword(password);
    }

    public User(String username, String password, String firstName, String lastName, String mobile_number, String emailAddress) throws InvalidPassword, InvalidMobileNumber, InvalidEmail {
        this.username = username;
        setPassword(password);
        this.firstName = firstName;
        this.lastName = lastName;
        setMobile_number(mobile_number);
        setEmailAddress(emailAddress);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setPassword(String password) throws InvalidPassword {
        if (password.length() < 7) {
            throw new InvalidPassword("Password must be longer than 7 characters");
        }
        String mustIncludeADigit = ".*[0-9]+.*";
        if (!password.matches(mustIncludeADigit)) {
            throw new InvalidPassword("Password must contain a Digit");
        }
        String mustIncludeAUpperCaseLetter = ".*[A-Z]+.*";
        if (!password.matches(mustIncludeAUpperCaseLetter)) {
            throw new InvalidPassword("Password must contain an Uppercase Letter");
        }
        this.password = password;
    }

    public void setMobile_number(String mobile_number) throws InvalidMobileNumber {
        if (mobile_number.length() != 10) {
            throw new InvalidMobileNumber("Mobile number should be 10 digits");
        }
        String includesNonDigit = ".*[A-Z]+.*";
        if (mobile_number.matches(includesNonDigit)) {
            throw new InvalidMobileNumber("Mobile number should not contain characters");
        }
        this.mobile_number = mobile_number;
    }

    public void setEmailAddress(String emailAddress) throws InvalidEmail {
        if (!emailAddress.contains("@")) {
            throw new InvalidEmail("That doesn't look like an email address to me");
        }
        this.emailAddress = emailAddress;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
