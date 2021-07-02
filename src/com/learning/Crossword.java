package com.learning;

import java.util.Scanner;

public class Crossword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] input = new char[10][10];
        for (int i = 0; i < 10; i++) {
            String s = sc.next();
            for (int j = 0; j < 10; j++) {
                input[i][j] = s.charAt(j);
            }
        }
        String words = sc.next();
        String[] word = words.split(";");

        solveCrossword(input, word, 0);
    }


    public static boolean solveCrossword(char[][] input, String[] word, int index) {
        /*ArrayList<Boolean> helper = new ArrayList<>();
        Collections.fill(helper, Boolean.FALSE);*/
        boolean[] helper;
        if (index == word.length) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    System.out.print(input[i][j] + " ");
                }
                System.out.println();
            }
            return true;
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (input[i][j] == '-' || input[i][j] == word[index].charAt(0)) {
                    if (isValidVertical(input, word[index], i, j)) {
                        helper = new boolean[word[index].length()];
                        setVertical(input, word[index], helper, i, j);
                        if (!solveCrossword(input, word, index + 1)) {
                            resetVertical(input, word[index], helper, i, j);
                        }
                    }
                    if (isValidHorizontal(input, word[index], i, j)) {
                        helper = new boolean[word[index].length()];
                        setHorizontal(input, word[index], helper, i, j);
                        if (!solveCrossword(input, word, index + 1)) {
                            resetHorizontal(input, word[index], helper, i, j);
                        }
                    }
                }
            }
        }
        return false;
    }

    private static void resetVertical(char[][] input, String currentWord, boolean[] helper, int row, int col) {
        for (int i = row, j = 0; i < 10 && j < currentWord.length(); i++, j++) {
            if (helper[j] == true) {
                input[i][col] = '-';
                helper[j] = false;
            }
        }
        return;
    }

    private static void resetHorizontal(char[][] input, String currentWord, boolean[] helper, int row, int col) {
        for (int i = col, j = 0; i < 10 && j < currentWord.length(); i++, j++) {
            if (helper[j] == true) {
                input[row][i] = '-';
                helper[j] = false;
            }
        }
        return;
    }

    private static void setVertical(char[][] input, String currentWord, boolean[] helper, int row, int col) {
        for (int i = row, j = 0; i < 10 && j < currentWord.length(); i++, j++) {
            if (input[i][col] != currentWord.charAt(j)) {
                input[i][col] = currentWord.charAt(j);
                helper[j] = true;
            }
        }
        return;
    }

    private static void setHorizontal(char[][] input, String currentWord, boolean[] helper, int row, int col) {
        for (int i = col, j = 0; i < 10 && j < currentWord.length(); i++, j++) {
            if (input[row][i] != currentWord.charAt(j)) {
                input[row][i] = currentWord.charAt(j);
                helper[j] = true;
            }
        }
        return;
    }

    private static boolean isValidVertical(char[][] input, String currentWord, int row, int col) {
        int maxLen = 10 - row;
        if (maxLen < currentWord.length()) {
            return false;
        }
        for (int r = row, i = 0; r < 10 && i < currentWord.length(); r++, i++) {
            if (!(input[r][col] == '-' || input[r][col] == currentWord.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidHorizontal(char[][] input, String currentWord, int row, int col) {
        //check if enough spaces available
        int maxLen = 10 - col;
        if (maxLen < currentWord.length()) {
            return false;
        }
        for (int c = col, i = 0; c < 10 && i < currentWord.length(); c++, i++) {
            if (!(input[row][c] == '-' || input[row][c] == currentWord.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
