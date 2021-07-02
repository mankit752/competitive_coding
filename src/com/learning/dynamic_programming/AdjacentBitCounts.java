package com.learning.dynamic_programming;

import java.util.Scanner;

public class AdjacentBitCounts {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int num = sc.nextInt();
            int x = sc.nextInt();
            int k = sc.nextInt();

            int res = countAdjacentBits(x, k);
            System.out.println(i + " " + res);
        }

    }

    private static int countAdjacentBits(int x, int k) {
        int m = 1000000007;
        long dp[][][] = new long[x + 1][k + 1][2];

        dp[1][0][0] = 1;
        dp[1][0][1] = 1;

        for (int i = 2; i <= x; i++) {
            for (int j = 0; j < i && j < k + 1; j++) {
                dp[i][j][0] = (dp[i - 1][j][0] % m + dp[i - 1][j][1] % m) % m;
                dp[i][j][1] = dp[i - 1][j][0] % m;
                if (j - 1 >= 0) {
                    dp[i][j][1] = (dp[i][j][1] % m + dp[i - 1][j - 1][1] % m) % m;
                }
            }
        }
        return (int) (dp[x][k][0] % m + dp[x][k][1] % m) % m;
    }
}
