package com.javafortesters2.chap012inheritance.examples;

import com.javafortesters2.domainentities.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by andfin on 10/01/2017.
 */
public class EmptyUser extends User{
    @Test
    public void blahBLah(){
        EmptyUser andy = new EmptyUser();
        assertEquals("username",andy.getUsername());
        assertEquals("password",andy.getPassword());
    }
}
