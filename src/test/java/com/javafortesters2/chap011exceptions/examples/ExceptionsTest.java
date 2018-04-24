package com.javafortesters2.chap011exceptions.examples;

import com.javafortesters2.domainentities.InvalidEmail;
import com.javafortesters2.domainentities.InvalidMobileNumber;
import com.javafortesters2.domainentities.InvalidPassword;
import com.javafortesters2.domainentities.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by andfin on 10/01/2017.
 */
public class ExceptionsTest {
    @Test
    public void throwANullPointer(){
        Integer age = 18;
        String ageToString = age.toString();
        String yourAge = "You are "+ageToString+" years old";
        assertEquals("You are 18 years old",yourAge);
    }
    @Test
    public void tryCatchANullPointer(){
        Integer age=null;
        String ageAsString;
        try{
            ageAsString=age.toString();
        }catch(NullPointerException e){
            age=18;
            ageAsString=age.toString();
        }
        assertEquals("18",ageAsString);
    }
    @Test
    public void illegalArgumentException()throws InvalidPassword {
        try {
            User bob = new User("bob","123456");
        }catch(InvalidPassword e){
        System.out.println("Caught IllegalArgumentException");
        }finally {
            User bob = new User("bob","Passw0rd");
            assertEquals("bob", bob.getUsername());
        }

    }
    @Test
    public void invalidMobileNumberException()throws Throwable{
        try {
            User user = new User("username","Password1","andy","finlayson","123456789","test@test.com");
        }catch (InvalidMobileNumber e){
            assertEquals(e.getMessage(),"Mobile number should be 10 digits");
        }

        try {
            User user = new User("username","Password1","andy","finlayson","12345678910","test@test.com");
        }catch (InvalidMobileNumber e){
            assertEquals(e.getMessage(),"Mobile number should be 10 digits");
        }

        try {
            User user = new User("username","Password1","andy","finlayson","123456789A","test@test.com");
        }catch (InvalidMobileNumber e){
            assertEquals(e.getMessage(),"Mobile number should not contain characters");
        }
    }

    @Test
    public void invalidEmailAddressException()throws Throwable{
        try {
            User user = new User("username","Password1","andy","finlayson","1234567890","test.com");
        }catch (InvalidEmail e){
            assertEquals(e.getMessage(),"That doesn't look like an email address to me");
        }
    }
}
