package com.coding_practice.dynamic_programming;

import java.util.Scanner;

public class SamAndSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        System.out.println(count(s));
    }

    private static long count(String s) {
        int mod = 1000000007;
        long sum = s.charAt(0) - 48;
        long lastValue = s.charAt(0) - 48;

        for (int i = 1; i < s.length(); i++) {
            int t = s.charAt(i) - 48;
            lastValue = ((lastValue * 10) + (t * (i + 1))) % mod;
            sum = (sum +lastValue) % mod;
        }
        return sum;
    }
}
