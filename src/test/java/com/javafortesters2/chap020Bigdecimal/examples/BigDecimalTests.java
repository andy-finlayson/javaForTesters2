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

        BigDecimal bd = BigDecimal.ZERO;
        bd = bd.add(BigDecimal.TEN);
        bd = bd.multiply(BigDecimal.valueOf(2L));
        bd = bd.subtract(BigDecimal.TEN);
        bd = bd.divide((BigDecimal.valueOf(2L)));
        assertThat(bd.equals(BigDecimal.valueOf(5)),is(true));

    }
    @Test
    public void compareTenAndOne(){
        BigDecimal ten = BigDecimal.TEN;
        BigDecimal one = BigDecimal.ONE;
        assertThat(ten.compareTo(one),is(1));
        assertThat(one.compareTo(ten),is(-1));
        assertThat(ten.compareTo(ten),is(0));
    }
}
