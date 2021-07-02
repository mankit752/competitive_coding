package com.coding_practice.dynamic_programming;

import java.util.Scanner;

public class MagicGrid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int input[][] = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    input[i][j] = sc.nextInt();
                }
            }

            int dp[][] = new int[r][c];
            dp[r - 1][c - 1] = 1;
            for (int i = r - 2; i >= 0; i--) {
                dp[i][c - 1] = Math.max(1, dp[i + 1][c - 1] - input[i][c - 1]);
            }
            for (int j = c - 2; j >= 0; j--) {
                dp[r - 1][j] = Math.max(1, dp[r - 1][j + 1] - input[r - 1][j]);
            }

            for (int i = r - 2; i >= 0; i--) {
                for (int j = c - 2; j >= 0; j--) {
                    dp[i][j] = Math.max(1, Math.min((dp[i + 1][j] - input[i][j]), dp[i][j + 1] - input[i][j]));
                }
            }
            System.out.println(dp[0][0]);
        }
        return;
    }
}
