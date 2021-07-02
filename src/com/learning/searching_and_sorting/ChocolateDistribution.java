package com.learning.searching_and_sorting;

import java.util.Arrays;
import java.util.Scanner;

public class ChocolateDistribution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);

            int l = 0, r = arr[n - 1];
            int res = 0;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (check(arr, n, mid, k)) {
                    res = mid;
                    l = mid +1;
                } else {
                    r = mid -1;
                }
            }
            System.out.println(res);

        }
    }

    private static Boolean check(int[] arr, int n, int mid, int k) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += arr[i] / mid;
        }
        if (count >= k) {
            return true;
        } else {
            return false;
        }
    }
}
