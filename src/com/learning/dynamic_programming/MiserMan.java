package com.learning.dynamic_programming;

import java.util.Scanner;

public class MiserMan {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int input[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                input[i][j] = sc.nextInt();
            }
        }

        int dp[][] = new int[n][m];
        for (int i = 0; i < m; i++) {
            dp[0][i] = input[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int l, r, u;
                l = (j > 0) ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
                u = dp[i-1][j];
                r = (j < m - 1) ? dp[i - 1][j + 1] : Integer.MAX_VALUE;
                dp[i][j] = input[i][j] + Math.min(l, Math.min(u, r));
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++) {
            if(dp[n-1][i] < ans) {
                ans = dp[n-1][i];
            }
        }
        System.out.println(ans);
    }
}
