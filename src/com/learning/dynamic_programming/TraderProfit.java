package com.learning.dynamic_programming;

import java.util.Scanner;

public class TraderProfit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();

        while (q-- > 0) {
            int k = sc.nextInt();
            int n = sc.nextInt();

            int input[] = new int[n];

            for (int i = 0; i < n; i++) {
                input[i] = sc.nextInt();
            }

            System.out.println(maxProfit(input, n, k));
        }
    }

    private static int maxProfit(int[] input, int n, int k) {

        int dp[][] = new int[k + 1][n + 1];

        for (int i = 1; i <= k; i++) {
            int prevDiff = Integer.MIN_VALUE;
            for (int j = 1; j < n; j++) {
                prevDiff = Math.max(prevDiff, dp[i - 1][j - 1] - input[j - 1]);
                dp[i][j] = Math.max(dp[i][j - 1], input[j] + prevDiff);
            }
        }
        return dp[k][n - 1];

    }

}
