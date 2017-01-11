package com.javafortesters2.domainentities;

/**
 * Created by andfin on 11/01/2017.
 */
public class InvalidPassword extends Exception {
    public InvalidPassword(String message){
        super(message);
    }
}
