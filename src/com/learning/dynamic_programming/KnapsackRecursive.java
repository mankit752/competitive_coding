package com.learning.dynamic_programming;

import java.util.Scanner;

public class KnapsackRecursive {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int weight[] = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = s.nextInt();
        }
        int value[] = new int[n];
        for (int i = 0; i < n; i++) {
            value[i] = s.nextInt();
        }
        int maxWeight = s.nextInt();
        System.out.println(knapsack(weight, value, maxWeight));

    }

    private static int knapsack(int[] weight, int[] value, int maxWeight) {
        int n = weight.length;
        int dp[][] = new int[n][maxWeight + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= maxWeight; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(weight, value, maxWeight, n - 1, dp);
    }

    private static int helper(int[] weight, int[] value, int maxWeight, int n, int[][] dp) {
        if (n < 0) {
            return 0;
        }
        if (dp[n][maxWeight] != -1) {
            return dp[n][maxWeight];
        }
        if (weight[n] <= maxWeight) {
            dp[n][maxWeight] = Math.max((value[n] + helper(weight, value, maxWeight - weight[n], n - 1, dp)),
                    helper(weight, value, maxWeight, n - 1, dp));
        } else {
            dp[n][maxWeight] = helper(weight, value, maxWeight, n - 1, dp);
        }
        return dp[n][maxWeight];
    }
}
