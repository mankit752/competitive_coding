package com.learning.backtracking;

import java.util.Scanner;

public class Sudoku {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int board[][] = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = s.nextInt();
            }
        }
        //System.out.println(sudokuSolver(board));
        sudokuSolver(board);
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean sudokuSolver(int[][] board) {
        int arr[] = new int[2];
        Integer row = -1, col = -1;
        if (!findEmptyPosition(board, arr)) {
            return true;
        }
        row = arr[0];
        col = arr[1];
        for (int i = 1; i <= 9; i++) {
            if(isSafe(board, row, col, i)) {
                board[row][col] = i;
                if(sudokuSolver(board)) {
                    return true;
                }
            }
            board[row][col] = 0;
        }
        return false;
    }

    private static boolean isSafe(int[][] board, Integer row, Integer col, int num) {
        if (isSafeRow(board, row, num) && isSafeColumn(board, col, num) && isSafeBox(board, row, col, num)) {
            return true;
        }
        return false;
    }

    private static boolean isSafeBox(int[][] board, Integer row, Integer col, int num) {
        int rowfactor = row - (row % 3);
        int colFactor = col - (col % 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + rowfactor][j + colFactor] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isSafeRow(int[][] board, Integer row, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSafeColumn(int[][] board, Integer col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }
        return true;
    }

    private static boolean findEmptyPosition(int[][] board, int[] arr) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    arr[0] = i;
                    arr[1] = j;
                    return true;
                }
            }
        }
        return false;
    }
}
