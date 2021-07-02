package com.learning.dynamic_programming;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        System.out.println(fibonacci(n, arr));
    }

    private static int fibonacci(int n, int[] arr) {
        if(n == 0 || n == 1) {
            return n;
        }
        if(arr[n] > 0) {
            return arr[n];
        }
        int output = fibonacci(n-1, arr) + fibonacci(n-2, arr);
        arr[n] = output;
        return output;
    }
}
