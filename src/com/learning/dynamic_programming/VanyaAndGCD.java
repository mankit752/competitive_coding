package com.learning.dynamic_programming;

import java.util.Scanner;

public class VanyaAndGCD {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int input[] = new int[n];

        for(int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }

        System.out.println(problem(n, input));

    }

    private static int problem(int n, int[] input) {
        int dp[][] = new int[n][100];
        for(int i = 0; i < n; i++) {

        }
        return 0;
    }

    private static int gcd(int n1, int n2) {
        while(n1 != n2)
        {
            if(n1 > n2)
                n1 -= n2;
            else
                n2 -= n1;
        }
        return n1;
    }
}
