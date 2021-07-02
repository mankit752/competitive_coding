package com.learning;

import java.util.Scanner;

public class RemoveDuplicates {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        String input = s.next();
        System.out.println(removeConsecutiveDuplicates(input));
    }

    public static String removeConsecutiveDuplicates(String input) {
        if (input.length() == 0 || input.length() == 1) {
            return input;
        }
        if(input.charAt(0) == input.charAt(1)) {
            return removeConsecutiveDuplicates(input.substring(1));
        } else {
            return input.charAt(0) + removeConsecutiveDuplicates(input.substring(1));
        }
    }
}
