package com.javafortesters2.chap015stringsrevisited.examples;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by andfin on 11/01/2017.
 */
public class StringsRevisitedTest {
    @Test
    public void messingAboutWithStrings(){
        String string1 = "there is a tab ->\t<-";
        System.out.println(string1);
        String string2 = "there is a backspace->\b<-";
        System.out.println(string2);
        String string3 = "there is a new line ->\n<-";
        System.out.println(string3);
        String string4 = "there is a carriage return->\r<- well at least it used to be a carriage return";
        System.out.println(string4);
        String string6 = "there is a new double quote ->\"<-";
        System.out.println(string6);
        String string7 = "there is a new backslash ->\\<-";
        System.out.println(string7);
    }
    @Test
    public void charArray(){
        char[] cArray = {'2','3'};
        assertThat("23".toCharArray(), is(cArray));
        System.out.println("23".toCharArray());

    }

}
