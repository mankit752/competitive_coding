package com.learning.dynamic_programming;

import java.util.Scanner;

public class PartyProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int budget = sc.nextInt();
            int n = sc.nextInt();

            if (budget == 0 && n == 0) {
                return;
            }

            int[] fee = new int[n];
            int[] fun = new int[n];

            for (int i = 0; i < n; i++) {
                fee[i] = sc.nextInt();
                fun[i] = sc.nextInt();
            }

            int dp[][] = new int[n + 1][budget + 1];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= budget; j++) {
                    if (fee[i - 1] <= j) {
                        dp[i][j] = Math.max(dp[i - 1][j], fun[i - 1] + dp[i - 1][j - fee[i - 1]]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            int temp = dp[n][budget];
            int minCost = 0;

            for(int b = 0; b <= budget; b++) {
                if(dp[n][b] == temp) {
                    minCost = b;
                    break;
                }
            }
            System.out.println(minCost + " " + dp[n][budget]);

        }
    }

}
