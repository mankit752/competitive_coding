package com.coding_practice.more_adhoc;

import java.util.Scanner;

public class Keypad {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int input = s.nextInt();
        keypad(input);

    }

    static String[] codes = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void keypad(int input) {
        helper(input, "");
    }

    private static void helper(int input, String curr) {
        if (input == 0) {
            System.out.println(curr + "");
        }
        int size = getSize(input);
        double temp = input / Math.pow(10, size);
        int t = (int) temp;
        double rem = input % Math.pow(10, size);
        for (int i = 0; i < codes[t].length(); i++) {
            helper((int) rem, curr + codes[t].charAt(i));
        }
    }

    public static int getSize(int n) {
        return (int) Math.log10(n);

    }


}
