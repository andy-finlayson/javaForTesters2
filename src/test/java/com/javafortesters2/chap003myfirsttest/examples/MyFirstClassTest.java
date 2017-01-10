package com.javafortesters2.chap003myfirsttest.examples;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by andfin on 03/01/2017.
 */
public class MyFirstClassTest {
    @Test
    public void canAddTwoPlusTwo(){
        int sum = 2+2;
        assertEquals("2+2=4",4,sum);
    }

    @Test
    public void canAddTwoMinusTwo(){
        int sum = 2-2;
        assertEquals("2-2=0",0,sum);
    }
    @Test
    public void canAddTwoTimesTen(){
        int sum = 2*10;
        assertEquals("2*10=20",20,sum);
    }


}
