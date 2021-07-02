package com.coding_practice.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LootHouses {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int[] takeInput() throws IOException {
        int n = Integer.parseInt(br.readLine().trim());

        if (n == 0) {
            return new int[0];
        }

        String[] strNums = br.readLine().trim().split("\\s");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strNums[i]);
        }

        return arr;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        int[] arr = takeInput();
        System.out.println(maxMoneyLooted(arr));
    }

    private static int maxMoneyLooted(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];

        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return arr[1];
        }

        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(arr[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[n - 1];
    }
}
