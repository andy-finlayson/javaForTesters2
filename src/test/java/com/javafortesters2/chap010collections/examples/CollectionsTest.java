package com.javafortesters2.chap010collections.examples;

import com.javafortesters2.domainentities.User;
import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by andfin on 04/01/2017.
 */
public class CollectionsTest {
    @Test
    public void simpleArrayExample(){
        //Declare and initialise an array
        String[] numbers0123 = {"zero","one","two","three"};
        //iterate over the array
        for(String numberText:numbers0123){
            System.out.println(numberText);
        }
    }
    @Test
    public void simpleListExample(){
        String[] numbers0123 = {"zero","one","two","three"};
        //The array above is converted to a list
        List<String> numbers = Arrays.asList(numbers0123);
        //The list is iterated over in the same way as an array would be
        for(String numberText:numbers){
            System.out.println(numberText);
        }
    }
    @Test
    public void buildingTheList(){
        List<String> numbers = new ArrayList<String>();
        numbers.add("zero");
        numbers.add("one");
        numbers.add("two");
        numbers.add("three");
        for(String number:numbers){
            System.out.println(number);
        }
        assertEquals("zero",numbers.get(0));
        assertEquals("three",numbers.get(3));
    }
    @Test
    public void forEachLoopStuff(){
        String[] someDays = {"Tuesday","Thursday","Wednesday","Monday","Saturday","Sunday","Friday"};
        List<String>days = Arrays.asList(someDays);

        int forCount = 0;
        for(String day:days){
            if(day.equals("Monday")){
                break;
            }
            forCount++;
        }
        assertEquals("Monday is at position 3 and the forCount stops",3,forCount);
    }
    @Test
    public void forLoopStuff(){
        String[] someDays = {"Tuesday","Thursday","Wednesday","Monday","Saturday","Sunday","Friday"};
        List<String>days = Arrays.asList(someDays);

        int loopCount;
        for(loopCount=0;loopCount<days.size();loopCount++){
            if(days.get(loopCount).equals("Monday")){
                break;
            }

        }
        assertEquals("Monday is at index 3 and the forCount stops",3,loopCount);
    }
    @Test
    public void whileLoop(){
        String[] someDays = {"Tuesday","Thursday","Wednesday","Monday","Saturday","Sunday","Friday"};
        List<String>days = Arrays.asList(someDays);

        int loopCount=0;
        while(!days.get(loopCount).equals("Monday")){
            loopCount++;
        }
        assertEquals("Monday is at index 3 and the forCount stops",3,loopCount);
    }
    @Test
    public void doWhileLoop(){
        String[] someDays = {"Tuesday","Thursday","Wednesday","Monday","Saturday","Sunday","Friday"};
        List<String>days = Arrays.asList(someDays);

        int loopCount = -1;
        do{
            loopCount++;
        }
        while(!days.get(loopCount).equals("Monday"));
        assertEquals("Monday is at index 3 and the forCount stops",3,loopCount);
    }
    @Test
    public void collections(){
        //create a new collection called workdays and add the days
        Collection<String> workdays = new ArrayList<>();
        workdays.add("Monday");
        workdays.add("Tuesday");
        workdays.add("Wednesday");
        workdays.add("Thursday");
        workdays.add("Friday");
        assertEquals(5,workdays.size());
        //create a new collection called workdaysList
        Collection<String> workdaysList = new ArrayList<>();
        //add all workdays to workdaysList
        workdaysList.addAll(workdays);
        assertEquals(5,workdaysList.size());
        assertTrue(workdaysList.containsAll(workdays));
        workdaysList.add("Sunday");
        workdaysList.remove("Sunday");
        assertFalse(workdaysList.contains("Sunday"));
        for(String days : workdaysList)
            System.out.println(days);

        workdays.clear();
        assertTrue(workdays.isEmpty());
        workdays.addAll(workdaysList);
        workdays.removeAll(workdaysList);
        assertTrue(workdays.isEmpty());
    }
    @Test
    public void createAndManipulateACollectionOfUsers(){
        Collection<User> Users = new HashSet<>();
        assertEquals(0, Users.size());
        assertTrue(Users.isEmpty());
        User andy = new User("andy1","pass1");
        User bob = new User("bob1","pass1");
        Users.add(andy);
        Users.add(bob);
        assertEquals(2, Users.size());
        assertFalse(Users.isEmpty());
        Collection<User> Users2 = new HashSet<>();
        User charlie = new User("charlie1","pass1");
        User dave = new User("dave1","pass1");
        Users2.add(charlie);
        Users2.add(dave);
        assertEquals(2,Users2.size());
        assertFalse(Users2.isEmpty());
        Users.addAll(Users2);
        assertEquals(4, Users.size());
        assertTrue(Users.contains(andy));
        assertTrue(Users.contains(bob));
        assertTrue(Users.contains(charlie));
        assertTrue(Users.contains(dave));
        Users2.removeAll(Users);
        assertEquals(0,Users2.size());
        Users.clear();
        assertEquals(0,Users.size());
    }
    @Test
    public void createAndManipulateAListOfUsers(){
        List<User> Users = new ArrayList<>();
        User andy = new User("andy1","pass1");
        User bob = new User("bob1","pass1");
        Users.add(bob);
        assertEquals(1,Users.size());
        Users.add(0,andy);
        assertEquals(2,Users.size());
        assertEquals(0,Users.indexOf(andy));
        assertEquals(1,Users.indexOf(bob));
        Users.remove(0);
        assertEquals(0,Users.indexOf(bob));
    }
    @Test
    public void createAndManipulateASetOfUsers(){
        Set<User> Users = new HashSet<>();
        User andy = new User("andy1","pass1");
        Users.add(andy);
        assertEquals(1,Users.size());
        Users.add(andy);
        assertEquals(1,Users.size());
    }
    @Test
    public void createAndManipulateAMapOfUsers(){
        Map<String,User> Users = new HashMap<>();
        User andy = new User("andy1","pass1");
        User bob = new User("bob1","pass1");
        Users.put("user1",bob);
        Users.put("user1",andy);
        assertFalse(Users.containsValue(bob));
        Users.put("user2",bob);
        assertEquals(2,Users.size());
    }
}

