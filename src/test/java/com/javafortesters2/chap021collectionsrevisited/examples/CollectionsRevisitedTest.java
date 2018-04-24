package com.javafortesters2.chap021collectionsrevisited.examples;

import com.javafortesters2.domainentities.DupeUserComparator;
import com.javafortesters2.domainentities.InvalidPassword;
import com.javafortesters2.domainentities.User;
import org.junit.Test;

import java.util.SortedSet;
import java.util.TreeSet;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by andfin on 30/01/2017.
 */
public class CollectionsRevisitedTest {
    @Test
    public void sortedSetMaintainsOrder (){
        SortedSet<String> sortedSet = new <String> TreeSet();
        sortedSet.add("c");
        sortedSet.add("b");
        sortedSet.add("a");
        sortedSet.add("d");
        sortedSet.add("e");
        sortedSet.add("a");
        assertThat(sortedSet.size(), is(5));
        assertThat(sortedSet.first(), is("a"));
        assertThat(sortedSet.last(), is("e"));

        String[] letters = new String[sortedSet.size()];
        sortedSet.toArray(letters);
        assertThat(letters[0],is("a"));
        assertThat(letters[1], is("b"));
        assertThat(letters[2], is("c"));
        assertThat(letters[3], is("d"));
        assertThat(letters[4], is("e"));

        SortedSet<String> anotherSortedSet = new <String> TreeSet();
        anotherSortedSet.add("c");
        anotherSortedSet.add("d");
        assertThat(anotherSortedSet.first(),is("c"));
        anotherSortedSet.add("a");
        assertThat(anotherSortedSet.first(),is("a"));
        anotherSortedSet.add("b");
        assertThat(anotherSortedSet.first(),is("a"));
        assertThat(anotherSortedSet.last(),is("d"));

        SortedSet<String> headSet = anotherSortedSet.headSet("c");
        assertThat(headSet.size(),is(2));
        assertThat(headSet.first(),is("a"));
        assertThat(headSet.last(),is("b"));

        SortedSet<String> tailSet = anotherSortedSet.tailSet("c");
        assertThat(tailSet.size(),is(2));
        assertThat(tailSet.first(),is("c"));
        assertThat(tailSet.last(),is("d"));

        SortedSet<String> subSet = anotherSortedSet.subSet("b", "d");
        assertThat(subSet.size(),is(2));
        assertThat(subSet.first(),is("b"));
        assertThat(subSet.last(),is("c"));

    }
    @Test
    public void comparator()throws InvalidPassword{
        User bob = new User("Bob","pa55Word1");//12
        User sun = new User("sunn","Tzu12345");//12
        User tiny = new User("TinyTim","Hello123");//15
        User mrBeer = new User("Stafford","Syst3m123");//18
        User rich = new User("Richie", "R1ch1eR1chR1ch");//20

        SortedSet<User> userSortedList = new TreeSet<User>(new DupeUserComparator());
        userSortedList.add(bob);
        userSortedList.add(tiny);
        userSortedList.add(rich);
        userSortedList.add(sun);
        userSortedList.add(mrBeer);
        User[] users = new User[userSortedList.size()];
        userSortedList.toArray(users);
        assertEquals(bob.getUsername(),users[0].getUsername());
        assertEquals(sun.getUsername(),users[1].getUsername());
        assertEquals(tiny.getUsername(),users[2].getUsername());
        assertEquals(mrBeer.getUsername(),users[3].getUsername());
        assertEquals(rich.getUsername(),users[4].getUsername());
    }
    @Test
    public void dupeComparator()throws InvalidPassword{
        User bob = new User("Bob","pa55Word1");//12
        User sun = new User("Bob","Tzu12345");//11
        SortedSet<User> userSortedList = new TreeSet<User>(new DupeUserComparator());
        userSortedList.add(bob);
        userSortedList.add(sun);
        User[] users = new User[userSortedList.size()];
        assertThat(users.length, is(1));
        assertThat(bob.getPassword(),is("pa55Word1"));

    }


}
