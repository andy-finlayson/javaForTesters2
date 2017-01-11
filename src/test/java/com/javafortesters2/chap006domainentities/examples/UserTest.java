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
        User user = new User("username","password");
        assertEquals("users username is 'username'","username",user.getUsername());
        assertEquals("users password is 'password'","password",user.getPassword());
    }
    @Test
    public void canSetPassword()throws InvalidPassword{
        User user = new User("username","password");
        assertEquals("users password is 'password'","password",user.getPassword());
        user.setPassword("password0");
        assertEquals("users new password is 'password0'","password0",user.getPassword());
    }

}
