package com.javafortesters2.chap013moreexceptions.examples;

import com.javafortesters2.domainentities.InvalidPassword;
import com.javafortesters2.domainentities.User;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by andfin on 11/01/2017.
 */
public class MoreExceptions {
    @Test(expected = InvalidPassword.class)
        public void constructUserWithException()throws InvalidPassword{
            User aUser = new User("username","p");
}
    @Test
        public void constructDefaultUserWIthNoException(){
            User aUser = new User();
            assertEquals("username",aUser.getUsername());
            assertEquals("password",aUser.getPassword());
}
    @Test
    public void shortPassword(){
        try {
            User aUser = new User("username", "p");
            fail("An Invalid Password Exception should have been thrown");
        }catch(InvalidPassword e){
            assertTrue(e.getMessage().startsWith("Password must be longer than 7 characters"));
        }
    }
}
