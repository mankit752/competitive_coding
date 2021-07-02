package com.coding_practice.more_adhoc;

import java.util.Scanner;

public class StringLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int length = lengthString(s);
        System.out.println(length);
    }

    private static int lengthString(String s) {
        if(s.equals("")) {
            return 0;
        }
        return 1+lengthString(s.substring(1));
    }
}
