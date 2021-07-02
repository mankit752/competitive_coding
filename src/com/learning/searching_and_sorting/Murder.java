package com.learning.searching_and_sorting;

import java.util.Scanner;

public class Murder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            long res = mergeSort(arr, 0, arr.length - 1);
            System.out.println(res);
        }
    }

    private static long mergeSort(int[] arr, int l, int r) {
        long res = 0;
        if (l < r) {
            int mid = l + (r - l) / 2;
            res += mergeSort(arr, l, mid);
            res += mergeSort(arr, mid + 1, r);
            res += merge(arr, l, r, mid);
        }
        return res;
    }

    private static long merge(int[] arr, int l, int r, int mid) {
        int n1 = mid - l + 1;
        int n2 = r - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[l + i];
        }

        for (int i = 0; i < n2; i++) {
            right[i] = arr[mid + 1 + i];
        }

        long res = 0;
        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (left[i] < right[j]) {
                arr[k++] = left[i];
                res += (n2 - j)*left[i] ;
                i++;
            } else {
                arr[k++] = right[j++];
            }
        }
        while(i < n1) {
            arr[k++] = left[i++];
        }
        while (j < n2) {
            arr[k++] = right[j++];
        }
        return res;
    }
}
