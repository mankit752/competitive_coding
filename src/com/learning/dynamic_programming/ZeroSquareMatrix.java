package com.learning.dynamic_programming;

import java.util.Scanner;

public class ZeroSquareMatrix {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int arr[][] = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                arr[i][j] = s.nextInt();
        System.out.println(findMaxSquareWithAllZeros(arr));
    }

    private static int findMaxSquareWithAllZeros(int[][] input) {
        int r = input.length;
        int c = input[0].length;

        int dp[][] = new int[r][c];

        int max = 0;
        for (int i = 0; i < c; i++) {
            if (input[0][i] == 0) {
                dp[0][i] = 1;
                max = 1;
            } else {
                dp[0][i] = 0;
            }
        }

        for (int j = 0; j < r; j++) {
            if (input[j][0] == 0) {
                dp[j][0] = 1;
                max = 1;
            } else {
                dp[j][0] = 0;
            }
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (input[i][j] == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                    if(dp[i][j] > max) {
                        max = dp[i][j];
                    }
                }
            }
        }
        return max;
    }
}
