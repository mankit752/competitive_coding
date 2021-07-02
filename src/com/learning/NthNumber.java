package com.learning;

import java.util.Scanner;

public class NthNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long n = sc.nextLong();

        System.out.println(solve(a, b, n));
    }

    private static long solve(long a, long b, long N) {
        long lcm = (a > b) ? a : b;

        while(true) {
            if(lcm % a == 0 && lcm % b == 0) {
                break;
            }
            ++lcm;
        }
        return lcm * N;
    }
}
