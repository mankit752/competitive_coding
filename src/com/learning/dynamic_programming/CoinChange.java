package com.learning.dynamic_programming;

import java.util.Scanner;

public class CoinChange {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner s = new Scanner(System.in);
        int numDenominations = s.nextInt();
        int denominations[] = new int[numDenominations];
        for (int i = 0; i < numDenominations; i++) {
            denominations[i] = s.nextInt();
        }

        int value = s.nextInt();

        System.out.println(countWaysToMakeChange(denominations, value));

    }

    private static int countWaysToMakeChange(int[] denominations, int value) {
        int n = denominations.length;

        return helper(denominations, value, n);
    }

    private static int helper(int[] denominations, int value, int n) {
        int[][] dp = new int[value + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= value; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= value; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];
                if (denominations[j - 1] <= i) {
                    dp[i][j] += dp[i -denominations[j-1]][j];
                }
            }
        }
        return dp[value][n];
    }
}
