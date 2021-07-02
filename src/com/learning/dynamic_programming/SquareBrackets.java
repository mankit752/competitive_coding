package com.learning.dynamic_programming;

import java.util.Scanner;

public class SquareBrackets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();

        while (d-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            boolean flag[] = new boolean[2 * n + 1];

            for (int i = 0; i < k; i++) {
                int t = sc.nextInt();
                flag[t - 1] = true;
            }

            System.out.println(squareBrackets(0, 0, 2 * n, n, flag));
        }
    }

    private static int squareBrackets(int o, int c, int total, int n, boolean[] flag) {
        int dp[][] = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        return helper(o, c, total, n, dp, flag);
    }

    private static int helper(int o, int c, int total, int n, int[][] dp, boolean[] flag) {

        if (o > n || c > n) {
            return 0;
        }
        if (o == n && c == n) {
            return 1;
        }
        if (dp[o][c] != -1) {
            return dp[o][c];
        }
        if (o == c || flag[o + c] == true) {
            dp[o][c] = helper(o + 1, c, total, n, dp, flag);
            return dp[o][c];
        } else if (o == n) {
            dp[o][c] = helper(o, c + 1, total, n, dp, flag);
            return dp[o][c];
        } else {
            int opton1 = helper(o + 1, c, total, n, dp, flag);
            int option2 = helper(o, c + 1, total, n, dp, flag);
            dp[o][c] = opton1 + option2;
            return dp[o][c];
        }
    }
}
