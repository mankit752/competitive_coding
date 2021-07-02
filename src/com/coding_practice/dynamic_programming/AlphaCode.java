package com.coding_practice.dynamic_programming;

import java.util.Scanner;

public class AlphaCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.next();
            if (s.equals("0")) {
                return;
            }
            int n = s.length();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = s.charAt(i) - 48;
            }

            System.out.println(codes(arr, n));
        }

    }

    private static int codes(int[] arr, int size) {
        long[] mem = new long[size];
        int m = (int) Math.pow(10, 9) + 7;
        /*if (size == 0) {
            return 1;
        }
        if ((size == 1 && arr[0] != 0)) {
            return 1;
        } else if ((size == 1 && arr[0] == 0)) {
            return 0;
        }*/
        mem[0] = 1;

        for (int i = 1; i < size; i++) {
            if (arr[i] > 0) {
                mem[i] = mem[i - 1] % m;
            }
            int value = arr[i - 1] * 10 + arr[i];
            if (value >= 10 && value <= 26) {
                if (i < 2) {
                    mem[i] += mem[0] % m;
                } else {
                    mem[i] += mem[i - 2] % m;
                }
            }

        }
        return (int) mem[size - 1] % m;
    }
}
