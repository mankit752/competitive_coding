package com.learning.dynamic_programming;

import java.util.Scanner;

public class MinStepsToOne {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int dp[] = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        System.out.println(countWays(n, dp));
        System.out.println(countMinStepsToO(n));
    }

    private static int countMinStepsToO(int n) {
        int dp[] = new int[n + 1];
        dp[1]  = 0;
        for (int i = 2; i <= n; i++) {
            int temp = dp[i - 1];
            if (i % 2 == 0) {
                temp = Math.min(dp[i / 2], temp);
            }
            if (i % 3 == 0) {
                temp = Math.min(dp[i / 3], temp);
            }
            dp[i] = temp + 1;

        }
        return dp[n];
    }

    private static int countWays(int n, int[] dp) {
        if (n == 1 || n == 2 || n == 3) {
            return dp[n];
        }
        int smallOutput;
        if (n % 3 == 0) {
            smallOutput = countWays(n / 3, dp);
        } else if (n % 2 == 0) {
            smallOutput = countWays(n / 2, dp);
        } else {
            smallOutput = countWays(n - 1, dp);
        }
        dp[n] += smallOutput + 1;
        return dp[n];
    }
}
