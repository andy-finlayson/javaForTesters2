package com.javafortesters2.chap006domainentities.examples;

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

}
