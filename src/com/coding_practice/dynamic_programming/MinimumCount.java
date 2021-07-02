package com.coding_practice.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumCount {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine().trim());
        System.out.println(minCount(n));
    }

    private static int minCount(int n) {
        int dp[] = new int[n + 1];
        for(int j = 1; j <= n; j++) {
            dp[j] = Integer.MAX_VALUE;
            for (int i = 1; i * i <= j; i++) {
                dp[j] = Math.min(dp[j], 1 + dp[j - i * i]);
            }
        }
        return dp[n];
    }

}
