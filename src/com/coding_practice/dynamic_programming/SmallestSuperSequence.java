package com.coding_practice.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SmallestSuperSequence {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String str1 = br.readLine();
        String str2 = br.readLine();
        int min_len = smallestSuperSequence(str1, str2);
        System.out.print(min_len);
    }

    private static int smallestSuperSequence(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();

        int dp[][] = new int[n1 + 1][n2 + 1];
        for (int i = n1; i >= 0; i--) {
            dp[i][n2] = n1 - i;
        }
        for (int i = n2; i >= 0; i--) {
            dp[n1][i] = n2 - i;
        }
        for(int i = n1-1; i >=0; i--) {
            for(int j = n2-1; j >= 0; j--) {
                if(str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }
}
