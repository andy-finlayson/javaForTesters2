package com.javafortesters2.chap008secltionsanddecsions.examples;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by andfin on 03/01/2017.
 */
public class SelectionsAndDecisionsTest {
    @Test
    public void catOrCats(){
        int numberOfCats=1;
        assertEquals("1 Cat","cat",(numberOfCats == 1) ? "cat":"cats");
        numberOfCats=2;
        assertEquals("2 Cats","cats",(numberOfCats == 1) ? "cat":"cats");
        numberOfCats=0;
        assertEquals("0 Cats","cats",(numberOfCats == 1) ? "cat":"cats");
    }
    @Test
    public void assertTrueIfTrue(){
        boolean truthy = true;
        if(truthy == true)
            assertTrue(truthy);
            assertFalse(!truthy);
    }
    @Test
    public void assertTrueIfTrueElseAssertFalse(){
        boolean truthy = true;
        if(truthy == true) {
            assertTrue(truthy);
            assertFalse(!truthy);
        }
        else{
            assertFalse(truthy);
            assertTrue(!truthy);
            }
        }
    @Test
    public void switchStatement() {
        assertEquals("M", likelyGenderIs("SIR"));
        assertEquals("F", likelyGenderIs("IOPUHB"));
    }
        public String likelyGenderIs(String title){
            String likelyGender;
            switch (title.toLowerCase()){
                case "sir":likelyGender="M";
                    break;
                case "mr":likelyGender="M";
                    break;
                case "master":likelyGender="M";
                    break;
                default:likelyGender="F";
                    break;
            }
            return likelyGender;
        }
    @Test
    public void switchOnShortCode(){
        assertEquals("United Kingdom",countryCodeIs("UK"));
        assertEquals("United States",countryCodeIs("UsA"));
        assertEquals("United States",countryCodeIs("uS"));
        assertEquals("France",countryCodeIs("fR"));
        assertEquals("Sweden",countryCodeIs("se"));
        assertEquals("Rest Of World",countryCodeIs("ug"));
    }
        public String countryCodeIs(String code){
            String country;
            switch (code.toLowerCase()){
                case "uk":country="United Kingdom";
                    break;
                case "us":
                case "usa":country="United States";
                    break;
                case "fr":country="France";
                    break;
                case "se":country="Sweden";
                    break;
                default:country="Rest Of World";
            }
            return country;
        }
    @Test
    public void convertIntToString(){
        assertEquals("One", intIs(1));
        assertEquals("Two", intIs(2));
        assertEquals("Three", intIs(3));
        assertEquals("Four", intIs(4));
        assertEquals("Too Small", intIs(0));
        assertEquals("Too Big", intIs(5));
        assertEquals("Too Big", intIs(Integer.MAX_VALUE));
        assertEquals("Too Small", intIs(Integer.MIN_VALUE));
    }
    public String intIs(int digit){
        String number="";
         switch(digit){
            case 1:number = "One";
                break;
            case 2:number = "Two";
                break;
            case 3:number = "Three";
                break;
            case 4:number = "Four";
                break;
             default:
                    if(digit<1){number= "Too Small";
                    }
                    if(digit>4){number= "Too Big";
                    }
                break;
        }
        return number;
    }




    }



