package com.coding_practice.dynamic_programming;

import java.util.Scanner;

public class Boredom {
    public static int[] A=new int [100005];
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        for(int i=0;i<n;i++)
        {
            A[i]=scan.nextInt();
        }
        System.out.println(solve(n,A));
    }

    private static int solve(int n, int[] A) {
        int[] freq = new int[1001];
        freq[0] = 0;
        for(int i = 0; i < n; i++) {
            freq[A[i]]++;
        }

        int[] dp = new int[1001];
        dp[0] = 0;
        dp[1] = freq[1];
        for(int i = 2; i <= 1000; i++) {
            dp[i] = Math.max(dp[i-2] + i*freq[i], dp[i-1]);
        }
        return dp[1000];
    }
}
