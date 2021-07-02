package com.coding_practice.dynamic_programming;

import java.util.Scanner;

public class MinimumChocolates {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        System.out.println(getMin(arr, N));
    }

    private static int getMin(int[] arr, int N) {

        int dp[] = new int[N];
        dp[0] = 1;

        for (int i = 1; i < N; i++) {
            if (arr[i] > arr[i - 1]) {
                dp[i] = 1 + dp[i - 1];
            } else {
                dp[i] = 1;
            }
        }

        for (int i = N - 2; i >= 0; i--) {
            if ((arr[i] > arr[i + 1]) && (dp[i] <= dp[i + 1])) {
                dp[i] = 1 + dp[i + 1];
            }
        }
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += dp[i];
        }
        return sum;
    }
}
