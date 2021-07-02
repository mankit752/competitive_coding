package com.learning.dynamic_programming;

import java.util.Scanner;

public class KnapsackIterative {

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
        //System.out.println(knapsack(weight, value, maxWeight));
        System.out.println(knapsackSpaceEfficient(weight, value, maxWeight));

    }

    private static int knapsackSpaceEfficient(int[] weight, int[] value, int maxWeight) {
        int n = weight.length;
        int dp[][] = new int[2][maxWeight + 1];
        int i = 0;

        while (i < n) {
            int j = 1;
            if (i % 2 != 0) {
                while (j <= maxWeight) {
                    if (weight[i] > j) {
                        dp[1][j] = dp[0][j];
                    } else {
                        dp[1][j] = Math.max(dp[0][j], value[i] + dp[0][j - weight[i]]);
                    }
                    j++;
                }
            } else {
                while (j <= maxWeight) {
                    if (weight[i] > j) {
                        dp[0][j] = dp[1][j];
                    } else {
                        dp[0][j] = Math.max(dp[1][j], value[i] + dp[1][j - weight[i]]);
                    }
                    j++;
                }
            }
            i++;
        }
        return (n % 2 != 0) ? dp[0][maxWeight] : dp[1][maxWeight];
    }

    private static int knapsack(int[] weight, int[] value, int maxWeight) {
        int n = weight.length;
        int dp[][] = new int[n + 1][maxWeight + 1];
        if (n <= 0 || maxWeight <= 0) {
            return 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxWeight; j++) {
                if (weight[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], value[i - 1] + dp[i - 1][j - weight[i - 1]]);
                }
            }
        }
        return dp[n][maxWeight];
    }
}
