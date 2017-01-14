package com.javafortesters2.chap015stringsrevisited.examples;

import com.javafortesters2.domainentities.InvalidPassword;
import com.javafortesters2.domainentities.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

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
    @Test
    public void comparingString(){
        String hello = "Hello";
        assertThat(hello.compareTo("Hello"),is(0));
        assertThat(hello.compareToIgnoreCase("hELLO"),is(0));
        //compareTo returns a 4
        System.out.println(hello.compareTo("H"));
        assertThat(hello.compareTo("H") > 0, is(true));

        //compareTo returns a -4
        System.out.println(hello.compareTo("Hello1234"));
        assertThat(hello.compareTo("Hello1234") < 0, is(true));
    }
    @Test
    public void contains(){
        String hello = "Hello World";
        assertThat(hello.contains("o World"),is(true));
        assertThat(hello.contains("z"),is(false));
    }
    @Test
    public void regionMatches(){
        String hello = "Hello World";
        //true-ignores case, starts searching from this index, "string to search for", position in search string to start from, number of characters to use
        assertThat(hello.regionMatches(true,6,"Alice in Wonderland",9,2),is(true));
    }
    @Test
    public void findPositionsOfAllOccurrencesInAString(){
        System.out.println(searchAString("hello", "l"));
    }
    private List<Integer> searchAString(String string,String subString){
        List<Integer> occurrences = new ArrayList<Integer>();
            if(string == null || subString == null){
                throw new IllegalArgumentException("Cannot search using null");
            }
            if(subString.isEmpty()){
                throw new IllegalArgumentException("SubString is empty");
            }
            int lastPositionFound = 0;
            do {
                lastPositionFound = string.indexOf(subString,lastPositionFound);
                if(lastPositionFound != -1) {
                    occurrences.add(lastPositionFound);
                    lastPositionFound++;
                }
            }
            while (lastPositionFound != -1);
        return occurrences;
    }
    @Test
    public void passwordMustContainADigitAndUppercaseLetter()throws InvalidPassword{
        User user = new User("andy","Password1");
        assertEquals("Password1",user.getPassword());
        try {
            User bob = new User("bob","password1");
            fail("An Invalid Password Exception should have been thrown");
        }catch(InvalidPassword e){
            assertTrue(e.getMessage().startsWith("Password must contain an Uppercase Letter"));
        }
        try {
            User charlie = new User("charlie","Password");
            fail("An Invalid Password Exception should have been thrown");
        }catch(InvalidPassword e){
            assertTrue(e.getMessage().startsWith("Password must contain a Digit"));
        }
        try {
            User dave = new User("dave","password");
            fail("An Invalid Password Exception should have been thrown");
        }catch(InvalidPassword e){
            assertEquals(true,(e.getMessage().startsWith("Password must contain a Digit")));
        }
    }
    @Test
    public void replacingStrings(){
        String hello = "Hello blah blah blah";
        assertThat(hello.replaceFirst("blah", "whatever"), is("Hello whatever blah blah"));
        assertThat(hello.replace("blah","whatever"),is("Hello whatever whatever whatever"));
        assertThat(hello.replaceAll("blah","whatever"),is("Hello whatever whatever whatever"));
        assertThat("1,2,3".replaceFirst("[0-9]","number"),is("number,2,3"));
        assertThat("1,2,3".replaceAll("[0-9]","number"),is("number,number,number"));
        assertThat(hello.toUpperCase(),is("HELLO BLAH BLAH BLAH"));
        assertThat(hello.toLowerCase(),is("hello blah blah blah"));
        String whitespace = "     whitespace     ";
        assertThat(whitespace.trim(),is("whitespace"));
        assertThat(hello.substring(1,5),is("ello"));

        int value=4;
        String template = "The value %d was used";
        String formatted = String.format(template,value);
        assertThat(formatted,is("The value 4 was used"));

        String longText = "%s %s are a good way to lose £%d";
        assertThat(String.format(longText,"flying","pigs",100),is("flying pigs are a good way to lose £100"));
    }
    @Test
    public void split(){
        String csv = "1,2,3,4,5,6,7,8,9,10";
        String[] split = csv.split(",");
        assertThat(split[1],is("2"));
        assertThat(split.length,is(10));

    }
    @Test
    public void stringBuilder(){
        StringBuilder builder = new StringBuilder();
        assertThat(builder.append("Hello World").replace(7,11,"There").delete(5,7).reverse().toString(),is("erehTolleH"));

        StringBuilder another = new StringBuilder();
        another.append("is the second builder");
        another.insert(0,"This ");
        assertThat(another.toString(),is("This is the second builder"));
        another.insert(another.length()," i've made");
        assertThat(another.toString(),is("This is the second builder i've made"));

        StringBuilder abc = new StringBuilder("abcdefg");
        assertThat(abc.replace(1, 5, "123").toString(), is("a123fg"));

        StringBuilder reverse = new StringBuilder("reverse");
        assertThat(reverse.reverse().toString(), is("esrever"));

        StringBuilder subString = new StringBuilder("01234567");
        assertThat(subString.substring(1,6),is("12345"));
        assertThat(subString.substring(1),is("1234567"));

    }


}
