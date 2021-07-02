package com.learning;

import java.util.Scanner;

public class Power {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  x = sc.nextInt();
        int n = sc.nextInt();

        long res = power(x, n);
        System.out.println(res);
    }

    private static long power(int x, int n) {
        if(n == 0) {
            return 1;
        }
        return x * power(x, n-1);
    }
}
