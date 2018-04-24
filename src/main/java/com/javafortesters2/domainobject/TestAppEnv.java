package com.javafortesters2.domainobject;

/**
 * Created by andfin on 03/01/2017.
 */
public class TestAppEnv {
    public static final String DOMAIN = "192.123.0.3";
    public static final String PORT = "67";

    public static String getUrl() {
        return "http://" + DOMAIN + ":" + PORT;
    }

}
