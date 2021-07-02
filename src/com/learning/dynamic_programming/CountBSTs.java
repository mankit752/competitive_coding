package com.learning.dynamic_programming;

import java.util.Scanner;

public class CountBSTs {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        System.out.println(countTrees(x));
    }

    private static int countTrees(int numKeys) {
        int mod = 100000007;
        long dp[] = new long[numKeys + 1];

        dp[0] = 1;

        for (int i = 1; i <= numKeys; i++) {
            for (int j = 0; j < i; j++) {
                long temp = (dp[j] % mod * dp[i - j - 1] % mod) % mod;
                dp[i] = (dp[i] % mod + temp % mod) % mod;
            }
        }
        return (int) dp[numKeys];
    }
}
