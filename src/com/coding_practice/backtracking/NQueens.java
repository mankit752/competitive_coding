package com.coding_practice.backtracking;

import java.util.Scanner;

public class NQueens {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        placeNQueens(n);
    }

    static int[][] board;

    private static void placeNQueens(int n) {
        board = new int[n][n];
        helper(n, 0);
    }

    private static void helper(int n, int row) {
        if (row == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
            return;
        }
        for (int j = 0; j < n; j++) {
            if (isSafe(n, row, j)) {
                board[row][j] = 1;
                helper(n, row + 1);
                board[row][j] = 0;
            }
        }
        return;
    }

    private static boolean isSafe(int n, int row, int j) {
        //upper rows of same column
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        //upper left diagonal
        for (int i = row - 1, col = j - 1; i >= 0 && col >= 0; i--, col--) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        //upper right diagonal
        for (int i = row - 1, col = j + 1; i >= 0 && col < n; i--, col++) {
            if (board[i][col] == 1) {
                return false;
            }
        }
        return true;
    }
}
