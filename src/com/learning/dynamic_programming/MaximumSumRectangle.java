package com.learning.dynamic_programming;

import java.util.Scanner;

public class MaximumSumRectangle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();

        int input[][] = new int[r][c];
        boolean isPositive = false;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                input[i][j] = sc.nextInt();
                if(input[i][j] > max) {
                    max = input[i][j];
                }
                if(input[i][j] >= 0) {
                    isPositive = true;
                }
            }
        }
        if(isPositive == false) {
            System.out.println(max);
            return;
        }

        int dp[] = new int[r];
        int maxValue = 0;
        for (int left = 0; left < c; left++) {
            for (int i = 0; i < r; i++) {
                dp[i] = 0;
            }
            for (int right = left; right < c; right++) {
                for (int i = 0; i < r; i++) {
                    dp[i] += input[i][right];
                }
                int kadaneResult = kadane(dp);
                if(kadaneResult > maxValue) {
                    maxValue = kadaneResult;
                }
            }
        }
        System.out.println(maxValue);
    }

    private static int kadane(int[] dp) {
        int maxSoFar = 0;
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            maxSoFar += dp[i];
            if (max < maxSoFar) {
                max = maxSoFar;
            }
            if(maxSoFar < 0) {
                maxSoFar = 0;
            }
        }
        return max;
    }

}
