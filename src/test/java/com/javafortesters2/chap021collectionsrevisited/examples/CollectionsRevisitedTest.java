package com.javafortesters2.chap021collectionsrevisited.examples;

import com.javafortesters2.domainentities.User;
import com.javafortesters2.domainentities.UserComparator;
import org.junit.Test;

import java.util.SortedSet;
import java.util.TreeSet;

import static org.hamcrest.CoreMatchers.is;
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
    public void comparator(){
        SortedSet<User> userSortedList = new TreeSet<User>(new UserComparator);
    }


}
