package com.learning.dynamic_programming;

import java.util.Scanner;

public class BalikaVadhuProblem {

    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String str1 = sc.next();
            String str2 = sc.next();

            int k = sc.nextInt();

            System.out.println(balikaVadhu(str1, str2, k));
        }
    }

    private static int balikaVadhu(String str1, String str2, int k) {
        int m = str1.length();
        int n = str2.length();
        int dp[][][] = new int[m + 1][n + 1][k + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                for (int z = 0; z <= k; z++) {
                    dp[i][j][z] = -1;
                }
            }
        }

        if (lcs(str1, str2) >= k) {
            return helper(str1, str2, dp, m, n, k);
        } else
            return 0;

    }

    private static int helper(String str1, String str2, int[][][] dp, int m, int n, int k) {
        if (m <= 0 || n <= 0 || k <= 0) {
            return 0;
        }
        if (dp[m][n][k] != -1) {
            return dp[m][n][k];
        }
        int option1 = 0;
        int option2;
        int option3;

        if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
            option1 = helper(str1, str2, dp, m - 1, n - 1, k - 1) + (int) str1.charAt(m - 1);
        }
        option2 = helper(str1, str2, dp, m - 1, n, k);
        option3 = helper(str1, str2, dp, m, n - 1, k);
        dp[m][n][k] = Math.max(option1, Math.max(option2, option3));
        return dp[m][n][k];

    }

    private static int lcs(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int dp[][] = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }


}
