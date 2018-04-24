package com.javafortesters2.chap006domainentities.examples;

import com.javafortesters2.domainentities.InvalidEmail;
import com.javafortesters2.domainentities.InvalidMobileNumber;
import com.javafortesters2.domainentities.InvalidPassword;
import com.javafortesters2.domainentities.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by andfin on 03/01/2017.
 */
public class UserTest {
    @Test
    public void canCreateUser()throws InvalidPassword{
        User user = new User("username","Passw0rd");
        assertEquals("users username is 'username'","username",user.getUsername());
        assertEquals("users password is 'password'","Passw0rd",user.getPassword());
    }
    @Test
    public void canSetPassword()throws InvalidPassword{
        User user = new User("username","Passw0rd");
        assertEquals("users password is 'password'","Passw0rd",user.getPassword());
        user.setPassword("Passw0rd1");
        assertEquals("users new password is 'Passw0rd1'","Passw0rd1",user.getPassword());
    }

    @Test
    public void canCreateUserWithNames()throws InvalidPassword,InvalidMobileNumber,InvalidEmail{
        User user = new User("sovietsong","Password1","Andy","Finlayson","0723878108","test@test.com");
        assertEquals(user.getUsername(),"sovietsong");
        assertEquals(user.getPassword(),"Password1");
        assertEquals(user.getFirstName(),"Andy");
        assertEquals(user.getLastName(),"Finlayson");
        assertEquals(user.getMobile_number(),"0723878108");
        assertEquals(user.getEmailAddress(),"test@test.com");

    }

}
