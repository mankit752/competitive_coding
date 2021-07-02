package com.coding_practice.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShortestSubsequence {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String S, V;


        S = br.readLine();
        V = br.readLine();
        System.out.println(solve(S, V));

    }

    private static int solve(String s, String v) {
        int m = s.length();
        int n = v.length();

        int dp[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        int ans = helper(s, 0, m, v, 0, n, dp);
        return ans;
    }

    private static int helper(String s, int i, int m, String v, int j, int n, int[][] dp) {
        if (i == m) {
            return 1005;
        }
        if (j >= n) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = helper(s, i + 1, m, v, j, n, dp);
        char ch = s.charAt(i);
        int ans1, k;

        for (k = j; k < n; k++) {
            if (v.charAt(k) == ch) {
                break;
            }
        }
        if (k == n) {
            return 1;
        }
        ans1 = helper(s, i + 1, m, v, k + 1, n, dp) + 1;
        dp[i][j] = Math.min(ans, ans1);
        return dp[i][j];
    }

}
