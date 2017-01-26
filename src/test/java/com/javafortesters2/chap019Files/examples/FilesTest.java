package com.javafortesters2.chap019Files.examples;

import org.junit.Test;

import java.io.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by andfin on 24/01/2017.
 */
public class FilesTest {
        private File writeTheTestDataFile() throws IOException {
        File outputFile = File.createTempFile("forReading",null);
        PrintWriter print = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));
        for (int i = 0;i<6;i++){
            print.println("line"+i);
        }
        print.close();
        return outputFile;
    }
    @Test
    public void readTheAboveFile()throws IOException{
        File inputFile = writeTheTestDataFile();
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        try{
            String line;
            while((line = reader.readLine())!=null){
                System.out.println(line);
            }
        }
        finally{
            reader.close();
        }

    }

    @Test
    public void roots() {
        File[] roots = File.listRoots();
        for (File aFile : roots) {
            System.out.println(aFile.getAbsolutePath());
        }
    }
    @Test
    public void moreFiles()throws IOException{
        File createAFile = new File("C:/Users/andfin/Documents/newtextfile.txt");
        assertThat(createAFile.exists(), is(false));

        createAFile.createNewFile();
        assertThat(createAFile.exists(), is(true));

        createAFile.delete();
        assertThat(createAFile.exists(), is(false));

    }
    @Test
    public void createATempFileWithCustomCode() throws IOException{
        File customTempFile = new File(System.getProperty("java.io.tmpdir")+System.currentTimeMillis()+".tmp");
        customTempFile.createNewFile();
        assertThat(customTempFile.exists(),is(true));
        customTempFile.delete();
    }
    }



