package com.javafortesters2.chap020Bigdecimal.examples;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by andfin on 26/01/2017.
 */
public class BigDecimalTests {
    @Test
    public void exerciseOne(){
        BigDecimal number = new BigDecimal("5.00");
        assertThat(number.subtract(new BigDecimal("0.43")), is(new BigDecimal("4.57")));

    }
}
