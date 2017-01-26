package com.javafortesters2.chap018properties.examples;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by andfin on 20/01/2017.
 */
public class PropertiesTest {
    @Test
    public void properties(){
        Properties properties = new Properties();
        assertThat(properties.size(), is(0));
        properties.setProperty("browser","firefox");
        properties.setProperty("port","80");
        assertThat(properties.getProperty("browser"),is("firefox"));
        assertThat(properties.getProperty("port"),is("80"));
        properties.setProperty("port","8080");
        assertThat(properties.getProperty("port"),is("8080"));
        assertThat(properties.getProperty("missing"),is(nullValue()));
        assertThat(properties.getProperty("missing","defaultValue"),is("defaultValue"));
        for (String key : properties.stringPropertyNames()){
            System.out.println(key+" : "+properties.getProperty(key));
        }
        properties.list(System.out);
        assertThat(properties.containsKey("browser"),is(true));
        assertThat(properties.containsValue("firefox"),is(true));

    }
    @Test
    public void createAListOfProperties(){
        Properties properties = new Properties();
        properties.setProperty("name","bob");
        properties.setProperty("gender","male");
        properties.setProperty("password","paSSw0rd");
        assertThat(properties.size(), is(3));
        for (String key : properties.stringPropertyNames()){
            System.out.println(key+" : "+properties.getProperty(key));
        }
        properties.list(System.out);
        assertThat(properties.containsKey("gender"),is(true));
        assertThat(properties.getProperty("name"),is("bob"));
        assertThat(properties.getProperty("permission", "Admin"),is("Admin"));

    }
    @Test
    public void systemProperties() throws IOException{
        Properties sys = System.getProperties();
        //sys.list(System.out);

        String tmpDirectory = System.getProperty("java.io.tmpdir");
        String tmpResourceFilePath = new File(tmpDirectory,"tempFileForPropertiesStoreTest.properties").getAbsolutePath();

        Properties saved = new Properties();
        saved.setProperty("prop1","Hello");
        saved.setProperty("prop2","World");
        saved.list(System.out);

        FileOutputStream outputFile = new FileOutputStream(tmpResourceFilePath);
        saved.store(outputFile,"Hello There World");
        outputFile.close();
    }
    @Test
    public void output()throws  IOException{
        String tmpDirectory = System.getProperty("java.io.tmpdir");
        System.out.println(tmpDirectory);
        String tmpResourcePath = new File(tmpDirectory,"tempFileForPropertiesStoreTest.properties").getAbsolutePath();
        System.out.println(tmpResourcePath);

        Properties saved = new Properties();
        saved.setProperty("prop1","Hellow");
        saved.setProperty("prop2","World");

        FileOutputStream fos = new FileOutputStream(tmpResourcePath);
        saved.store(fos,"Comments");
        fos.close();

        FileReader propertyFileReader = new FileReader(tmpResourcePath);
        Properties loaded = new Properties();
        try{
            loaded.load(propertyFileReader);
        }
        finally {
            propertyFileReader.close();
        }
        assertThat(loaded.getProperty("prop1"),is("Hellow"));
    }
    @Test
    public void outputExercise()throws IOException{
        Properties properties = new Properties();
        properties.setProperty("property1","one");
        properties.setProperty("property2","two");
        properties.setProperty("property3","three");

        String tmpDirectory = System.getProperty("java.io.tmpdir");
        String resourcePath = new File(tmpDirectory,"andysTmpFile.txt").getAbsolutePath();

        FileOutputStream outputStream = new FileOutputStream(resourcePath);
        properties.store(outputStream,"Comments");

        FileReader reader = new FileReader(resourcePath);
        Properties loadedFromReader = new Properties();
        try{
            loadedFromReader.load(reader);
        }
        finally{
            reader.close();
        }
        assertThat(loadedFromReader.getProperty("property1"),is("one"));
        new File(resourcePath).delete();
    }
}
