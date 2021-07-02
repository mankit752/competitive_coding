package com.coding_practice.dynamic_programming;

import java.util.Scanner;

public class LongestBitonicSubset {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        System.out.println(longestBitonicSubarray(arr));

    }

    private static int longestBitonicSubarray(int[] arr) {
        int n = arr.length;
        int[] inc = new int[n];
        int[] dec = new int[n];

        lis(arr, n, inc);
        lds(arr, n, dec);

        int bestAnswer = inc[0] + dec[0] -1;
        for (int i = 1; i < n; i++) {
            if (inc[i] + dec[i] -1 > bestAnswer) {
                bestAnswer = inc[i] + dec[i] -1;

            }
        }
        return bestAnswer;
    }

    private static void lds(int[] arr, int n, int[] dec) {
        dec[n-1] = 1;
        for (int i = n-2; i >=0 ; i--) {
            dec[i] = 1;
            for (int j = n-1; j > i; j--) {
                if (arr[j] >= arr[i]) {
                    continue;
                }
                int possibleAnswer = dec[j] + 1;
                if (possibleAnswer > dec[i]) {
                    dec[i] = possibleAnswer;
                }
            }
        }
    }

    private static void lis(int[] arr, int n, int[] inc) {
        inc[0] = 1;
        for (int i = 1; i < n; i++) {
            inc[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] >= arr[i]) {
                    continue;
                }
                int possibleAnswer = inc[j] + 1;
                if (possibleAnswer > inc[i]) {
                    inc[i] = possibleAnswer;
                }
            }
        }
    }
}
