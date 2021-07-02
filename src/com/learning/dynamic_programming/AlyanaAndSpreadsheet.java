package com.learning.dynamic_programming;

import java.util.Scanner;

public class AlyanaAndSpreadsheet {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int input[][] = new int[m][n];
        int dp[][] = new int[m][n];
        int ans[] = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                input[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
            ans[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (input[i - 1][j] <= input[i][j]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = i + 1;
                }
            }
        }

        int answer[] = new int[m];
        for (int i = 0; i < m; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if(dp[i][j] < min) {
                    answer[i] = dp[i][j];
                }
            }
        }

        int q = sc.nextInt();
        /*for(int i  = 1; i < q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            if(answer[r - 1] < input[i][l]) {
                System.out.println("Yes");
            }
            else {
                System.out.println("No");
            }
        }*/

        for (int i = 1; i <= q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int flag = 0;

            for (int j = 0; j < n; j++) {
                if (dp[r - 1][j] <= l) {
                    System.out.println("YES");
                    flag = 1;
                    break;
                }
            }
            if (flag == 0)
                System.out.println("NO");
        }
    }
}
