package com.coding_practice.more_adhoc;

import java.util.Scanner;

public class WaterAndTheGrid {
    public static void main(String args[]) throws Exception {
        //Scanner
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        String[] input = new String[m];
        for (int i = 0; i < m; i++) {
            input[i] = sc.next();
        }

        /*char[][] charInput = new char[m][n];

        int[][] dp = new int[m][n];*/

        /*for (int i = 0; i < m; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            dp[n - 1][i] = 0;
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < n; i++) {
            dp[i][n - 1] = 0;
        }*/

        /*for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }*/

        int capacity = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if ((char)input[i].charAt(j) == '.' && isSafeDown(i, j, m, n, input) && isSafeUp(i, j, m, n, input) && isSafeLeft(i, j, m, n, input)
                        && isSafeRight(i, j, m, n, input)) {
                    capacity++;
                }
            }
        }
        System.out.println(capacity);

    }

    private static boolean isSafeUp(int i, int j, int m, int n, String[] input) {
        for (int x = i - 1; x >= 0; x--) {
            if (input[x].charAt(j) == '*') {
                return true;
            }
        }
        return false;
    }

    private static boolean isSafeDown(int i, int j, int m, int n, String[] input) {
        for (int x = i + 1; x < m; x++) {
            if (input[x].charAt(j) == '*') {
                return true;
            }
        }
        return false;
    }

    private static boolean isSafeLeft(int i, int j, int m, int n, String[] input) {
        for (int x = j - 1; x >= 0; x--) {
            if (input[i].charAt(x) == '*') {
                return true;
            }
        }
        return false;
    }

    private static boolean isSafeRight(int i, int j, int m, int n, String[] input) {
        for (int x = j + 1; x < n; x++) {
            if (input[i].charAt(x) == '*') {
                return true;
            }
        }
        return false;
    }
}

