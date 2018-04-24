package com.javafortesters2;

import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        SortedSet<Integer> horses = new <Integer>TreeSet();
        for (int i = 0; i < N; i++) {
            int pi = in.nextInt();
            horses.add(pi);
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        int difference =100000;
        if(horses.size()<N){
            difference =0;
        }
        Iterator itr = horses.iterator();
        while(itr.hasNext()){

        }

        System.out.println(difference);
    }
}