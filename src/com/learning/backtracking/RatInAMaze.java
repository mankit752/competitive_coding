package com.learning.backtracking;

import java.util.Scanner;

public class RatInAMaze {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int maze[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = s.nextInt();
            }
        }
        ratInAMaze(maze);
    }

    static int[][] solution;

    public static void ratInAMaze(int[][] maze) {
        solution = new int[maze.length][maze.length];
        helper(maze, 0, 0, maze.length);
    }

    private static void helper(int[][] maze, int row, int col, int n) {
        if (row == n - 1 && col == n - 1) {
            solution[row][col] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(solution[i][j] + " ");
                }
            }
            System.out.println();
            return;
        }

        if (col > n -1 || col < 0 || row > n-1 || row < 0 || maze[row][col] == 0 || solution[row][col] == 1)
            return;

        solution[row][col] = 1;
        helper(maze, row - 1, col, n);
        helper(maze, row + 1, col, n);
        helper(maze, row, col - 1, n);
        helper(maze, row, col + 1, n);
        solution[row][col] = 0;
    }
}
