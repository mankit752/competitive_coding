package com.coding_practice.more_adhoc;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Unique {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        LinkedHashSet<Character> set = new LinkedHashSet();
        for(int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        String st = new String();
        for (Character c: set) {
            st += c;
            System.out.print(c);
        }
    }
}
