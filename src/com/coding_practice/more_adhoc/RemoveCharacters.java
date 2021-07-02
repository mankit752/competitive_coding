package com.coding_practice.more_adhoc;

import java.util.Scanner;

public class RemoveCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char c = sc.next().charAt(0);

        String n = removeChar(s, c);
        System.out.println(n);
    }

    private static String removeChar(String s, char c) {
        if(s.length() == 0) {
            return s;
        }

        if(s.charAt(0) == c) {
            return removeChar(s.substring(1), c);
        }

        return s.charAt(0) + removeChar(s.substring(1), c);

    }
}
