package com.javafortesters2.chap009arrays.examples;

import com.javafortesters2.domainentities.User;
import org.junit.Test;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by andfin on 04/01/2017.
 */
public class ArraysTest {
    @Test
    public void arrayOfUsers(){
        //initialise the array
        User[] users = new User[3];
        //insert the users
        users[0] = new User("user1","pass1");
        users[1] = new User("user2","pass2");
        users[2] = new User("user3","pass3");
        //tests the creation of the data
        assertEquals(3, users.length);
        assertEquals("user1",users[0].getUsername());
        assertEquals("user2",users[1].getUsername());
        assertEquals("user3",users[2].getUsername());
        assertEquals("pass1",users[0].getPassword());
        assertEquals("pass2",users[1].getPassword());
        assertEquals("pass3",users[2].getPassword());
        //for loop to print out the Username
        for(User aUser:users){
            System.out.println(aUser.getUsername()+" // "+aUser.getPassword());
        }
    }
    @Test
    public void createAnArrayOfUsers(){
        User[] users = new User[100];
        for (int i=0;i<users.length;i++){
            users[i] = new User("user"+(i+1),"pass"+(i+1));
            System.out.println(users[i].getUsername()+" // "+users[i].getPassword());
        }
        assertEquals(100,users.length);
        assertEquals("user1",users[0].getUsername());
        assertEquals("pass1",users[0].getPassword());
        assertEquals("user100",users[99].getUsername());
        assertEquals("pass100",users[99].getPassword());
        }
    @Test
    public void sortWorkdays(){
        String[] workdays = {"Monday","Tuesday","Wednesday","Thursday","Friday"};
        Arrays.sort(workdays);
        assertEquals("Friday",workdays[0]);
        assertEquals("Monday",workdays[1]);
        assertEquals("Thursday",workdays[2]);
        assertEquals("Tuesday",workdays[3]);
        assertEquals("Wednesday",workdays[4]);
    }
    @Test
    public void createTriangle(){
        int[][] triangle = new int [16][];
        for( int row = 0; row < triangle.length; row++) {
            triangle[row] = new int[row + 1];
            for (int i = 0; i < (row + 1); i++) {
                triangle[row][i] = i;
            }
        }
        print2DIntArray(triangle);
    }
    public void print2DIntArray( int [][] multi) {
        for(int[] outer : multi){
            if(outer == null){
                System.out.print("null");
            }else{
                for(int inner : outer){
                    System.out.print(inner + ",");
                }
            }
            System.out.println("");
        }
    }

}
