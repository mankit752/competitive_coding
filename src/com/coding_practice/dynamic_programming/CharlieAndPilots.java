package com.coding_practice.dynamic_programming;

import java.util.Scanner;

public class CharlieAndPilots {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] captain = new int[n];
        int[] assistant = new int[n];

        for (int i = 0; i < n; i++) {
            captain[i] = sc.nextInt();
            assistant[i] = sc.nextInt();
        }

        System.out.println(minCost(captain, assistant, n));

    }

    private static int minCost(int[] captain, int[] assistant, int n) {
        int dp[][] = new int[n + 1][n / 2 + 1];
        return helper(captain, assistant, n, 0, 0, dp);
    }

    private static int helper(int[] captain, int[] assistant, int n, int x, int index, int[][] dp) {
        if (index >= n) {
            return 0;
        }
        if (dp[index][x] != 0) {
            return dp[index][x];
        }
        int ans;
        if (x == 0) {
            dp[index][x] = assistant[index] + helper(captain, assistant, n, 1, index + 1, dp);
            //helper(captain, assistant, n, 1, index+1, dp);
            return dp[index][x];

        } else if (x == n - index) {
            dp[index][x] = captain[index] + helper(captain, assistant, n, x - 1, index + 1, dp);
            return dp[index][x];
        } else {
            int option1 = assistant[index] + helper(captain, assistant, n, x + 1, index + 1, dp);
            int option2 = captain[index] + helper(captain, assistant, n, x - 1, index + 1, dp);
            ans = Math.min(option1, option2);
            dp[index][x] = ans;
            return ans;
        }
    }
}
