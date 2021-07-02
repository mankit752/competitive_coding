package com.coding_practice.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Staircase {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine().trim());
        System.out.println(staircase(n));
    }

    private static long staircase(int n) {
        long[] dp = new long[n + 1];
        long ways = helper(n, dp);
        return ways;
    }

    private static long helper(int n, long[] dp) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (dp[n] > 0) {
            return dp[n];
        }
        long smallOutput1 = helper(n - 1, dp);
        long smallOutput2 = helper(n - 2, dp);
        long smallOutput3 = helper(n - 3, dp);

        dp[n] = smallOutput1 + smallOutput2 + smallOutput3;
        return smallOutput1 + smallOutput2 + smallOutput3;
    }
}
