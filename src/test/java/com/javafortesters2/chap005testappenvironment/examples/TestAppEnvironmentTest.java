package com.javafortesters2.chap005testappenvironment.examples;
import org.junit.Test;

import com.javafortesters2.domainobject.TestAppEnv;
import static org.junit.Assert.assertEquals;

/**
 * Created by andfin on 03/01/2017.
 */
public class TestAppEnvironmentTest {
    @Test
    public void canGetUrl(){
        assertEquals("URL is http://192.123.0.3:67", "http://192.123.0.3:67", TestAppEnv.getUrl());
    }
    @Test
    public void canGetJustDomain(){
        assertEquals("Domain is http://192.123.0.3","192.123.0.3",TestAppEnv.DOMAIN);
    }
    @Test
    public void canGetJustPort(){
        assertEquals("Port is 67","67",TestAppEnv.PORT);
    }
    @Test
    public void urlAndPort(){
        assertEquals("Full URL is http://192.123.0.3:67","192.123.0.3:67",TestAppEnv.DOMAIN+":"+TestAppEnv.PORT);
    }
}
