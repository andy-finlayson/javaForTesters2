package com.javafortesters2.chap014junitexplored.examples;

import com.javafortesters2.domainentities.InvalidPassword;
import com.javafortesters2.domainentities.User;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by andfin on 11/01/2017.
 */
public class JunitExporedTest {
        @Test
    public void useAllOfTheAsserts()throws InvalidPassword{
            User[] users = new User[3];
            users[0] = new User("user1","Password1");
            users[1] = new User("user2","Password2");
            users[2] = new User("user3","Password3");

            assertTrue(true);
            assertFalse(false);
            assertEquals("2+2=4",4,2+2);
            assertArrayEquals(users,users);
            assertNotNull(users.length);
            assertNotSame(1,2);
            assertSame(2,2);
       }
        @Test
        public void useAssertThat()throws InvalidPassword{
                User[] users = new User[3];
                users[0] = new User("user1","Password1");
                users[1] = new User("user2","Password2");
                users[2] = new User("user3","Password3");

                assertThat(1,is(1));
                assertThat(1,equalTo(1));
                assertThat(1,not(2));
                assertThat(users,is(users));
                assertThat(1,not(nullValue()));
                assertThat(1,is(not(2)));
                assertThat(null,is(nullValue()));
                String andy="andy";
                assertThat(andy,startsWith("an"));
                assertThat(andy,endsWith("dy"));


        }

}
