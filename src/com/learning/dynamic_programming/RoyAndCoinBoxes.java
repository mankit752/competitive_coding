package com.learning.dynamic_programming;

import java.util.Scanner;

public class RoyAndCoinBoxes {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int m = sc.nextInt();
        int input[] = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            for (int j = l; j <= r; j++) {
                input[j]++;
            }
        }

        int dp[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= input[i]; j++)
                dp[j]++;
        }

        int q = sc.nextInt();
        for (int i = 1; i <= q; i++) {
            int t = sc.nextInt();
            System.out.println(dp[t]);
        }
    }

}
