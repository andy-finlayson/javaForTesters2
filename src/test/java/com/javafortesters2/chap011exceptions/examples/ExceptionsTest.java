package com.javafortesters2.chap011exceptions.examples;

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
}
