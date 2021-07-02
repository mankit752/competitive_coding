package com.coding_practice.dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class HasanTrip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int input[][] = new int[n][3];
        double dp[] = new double[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                input[i][j] = sc.nextInt();
            }
        }

        Arrays.fill(dp, -Double.MAX_VALUE);
        dp[0] = input[0][2];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j] - Math.sqrt(Math.pow(input[i][0] - input[j][0], 2) + Math.pow(input[i][1] - input[j][1], 2)));
            }
            dp[i] += input[i][2];
        }
        System.out.println(String.format("%.6f", dp[n - 1]));

    }
}
