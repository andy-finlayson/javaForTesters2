package com.javafortesters2.chap004exploringintegers.examples;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by andfin on 03/01/2017.
 */
public class ExploringIntegersTest {

    @Test
    public void toHexString(){
        assertEquals("11 in hex is b","b",Integer.toHexString(11));
        assertEquals("10 in hex is a","a",Integer.toHexString(10));
        assertEquals("3 in hex is 3","3",Integer.toHexString(3));
        assertEquals("21 in hex is 15","15",Integer.toHexString(21));
    }
    @Test
    public void minAndMaxIntegers(){
        assertEquals("Max integer is 2147483647",2147483647,Integer.MAX_VALUE);
        assertEquals("Min integer is -2147483648",-2147483648,Integer.MIN_VALUE);
    }
}
