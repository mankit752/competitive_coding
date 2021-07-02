package com.learning;

import java.util.ArrayList;
import java.util.Scanner;

public class SubSequence {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        ArrayList<String> list = new ArrayList<>();

        int l = seq(s, list);
        for(int i = 0; i < l; i++) {
            System.out.println(list.get(i));
        }
    }

    private static int seq(String s, ArrayList<String> list) {
        if(s.isEmpty()) {
            list.add("");
            return 1;
        }
        int smallOutput = seq(s.substring(1), list);
        for(int i = 0; i < smallOutput; i++) {
            String temp = s.charAt(0) + list.get(i);
            list.add(temp);
        }
        return 2*smallOutput;
    }
}
