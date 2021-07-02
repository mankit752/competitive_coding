package com.coding_practice.dynamic_programming;

import java.util.Scanner;

public class JonSnowFavouriteNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();

        int soldiers[] = new int[1025];
        int dp[] = new int[1025];
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            soldiers[t]++;
        }

        while (k-- > 0) {
            for (int j = 0; j < 1025; j++) {
                dp[j] = soldiers[j];
            }
            int parity = 0;
            for (int j = 0; j < 1025; j++) {
                if (soldiers[j] > 0) {
                    int curr = j ^ x;
                    int change = soldiers[j] / 2;
                    if (parity == 0) {
                        change += (soldiers[j] & 1);
                    }
                    dp[j] = dp[j] - change;
                    dp[curr] = dp[curr] + change;
                    parity = parity ^ (soldiers[j] & 1);
                }
            }
            for(int i = 0; i < 1025; i++) {
                soldiers[i] = dp[i];
            }
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 1025; i++) {
            if (dp[i] > 0) {
                min = Math.min(min, i);
                max = Math.max(max, i);
            }
        }

        System.out.println(max + " " + min);
    }
}
