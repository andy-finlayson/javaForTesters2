package com.javafortesters2.chap012inheritance.examples;

import com.javafortesters2.domainentities.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by andfin on 10/01/2017.
 */
public class EmptyUserTest extends User{
    @Test
    public void blahBLah(){
        EmptyUserTest andy = new EmptyUserTest();
        assertEquals("username",andy.getUsername());
        assertEquals("Passw0rd",andy.getPassword());
    }
}
