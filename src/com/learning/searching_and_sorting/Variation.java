package com.learning.searching_and_sorting;

import java.util.Arrays;
import java.util.Scanner;

public class Variation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        long count = 0;
        int i = 0, j = 1;
        while(j < n) {
            if (arr[j] - arr[i] >= k) {
                count += (n - j);
                i++;
            } else {
                j++;
            }
        }
        System.out.println(count);
    }
}
