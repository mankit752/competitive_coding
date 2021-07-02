package com.coding_practice.more_adhoc;

public class BookCriket {
    public static void main(String[] s) {
        System.out.println(noOfWaysToDrawTheGame(100));
    }

    private static int noOfWaysToDrawTheGame(int totalScore) {
        int dp[] = new int[100];
        if (totalScore % 2 != 0) {
            dp[0] = 0;
            return 0;
        } else if (totalScore == 0) {
            return 0;
        }
        if (totalScore == 2) {
            dp[2] = 1;
            return 1;
        } else if (totalScore == 4) {
            dp[4] = 2;
            return 2;
        } else if (totalScore == 6) {
            dp[6] = 4;
            return 4;
        }

        int way1 = noOfWaysToDrawTheGame(totalScore - 2);
        int way2 = noOfWaysToDrawTheGame(totalScore - 4);
        int way3 = noOfWaysToDrawTheGame(totalScore - 6);
        return noOfWaysToDrawTheGame(totalScore - 2) +
                noOfWaysToDrawTheGame(totalScore - 4) +
                noOfWaysToDrawTheGame(totalScore - 6);
    }
}
