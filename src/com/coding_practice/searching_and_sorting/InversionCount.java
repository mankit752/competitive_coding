package com.coding_practice.searching_and_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InversionCount {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static long[] takeInput() throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine().trim());
        long[] arr = new long[n];

        if (n == 0) {
            return arr;
        }

        String[] input = br.readLine().trim().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(input[i]);
        }

        return arr;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        long[] arr = takeInput();
        System.out.println(getInversions(arr));
    }

    private static long getInversions(long[] arr) {
        long n = arr.length;
        long l = 0;
        long r = n - 1;

        return helper(arr, l, r);
    }

    private static long helper(long[] arr, long l, long r) {
        long res = 0;
        if (l < r) {
            long mid = l + (r - l) / 2;
            res += helper(arr, l, mid);
            res += helper(arr, (mid + 1), r);
            res += merge(arr, l, r, mid);
        }
        return res;
    }

    private static long merge(long[] arr, long l, long r, long mid) {
        long n1 = mid - l + 1;
        long n2 = r - mid;
        long[] left = new long[(int)n1];
        long[] right = new long[(int)n2];
        for (int i = 0; i < n1; i++) {
            left[(int) i] = arr[(int)l + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = arr[(int)mid + 1 + j];
        }
        long res = 0, i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (left[(int)i] <= right[(int)j]) {
                arr[(int)k] = left[(int)i];
                k++;
                i++;
            } else {
                arr[(int)k] = right[(int)j];
                j++;
                k++;
                res = res + (n1 - i);
            }
        }
        while (i < n1) {
            arr[(int)k] = left[(int)i];
            k++;
            i++;
        }
        while (j < n2) {
            arr[(int)k] = right[(int)j];
            k++;
            j++;
        }
        return res;
    }

}
