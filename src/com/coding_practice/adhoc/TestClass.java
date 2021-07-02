package com.coding_practice.adhoc;

import java.io.IOException;
import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int dp[][] = new int[n+1][k+1];
            dp[0][0] = 1;

            for(int j = 0; j < k+1; j++) {
                for(int i = 1; i < n+1; i++) {
                    dp[i][j] += dp[i-1][j];
                    if(i > 1) {
                        dp[i][j] += dp[i - 2][j];
                    }
                    if(i > 2 && j > 0) {
                        dp[i][j] += dp[i - 3][j-1];
                    }
                }
            }
            int ways = 0;
            for(int j = 0; j < k+1; j++) {
                ways += dp[n][j];
            }
            System.out.println(ways);
        }
    }
}