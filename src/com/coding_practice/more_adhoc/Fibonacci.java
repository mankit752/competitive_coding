package com.coding_practice.more_adhoc;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(25));
    }

    public static long fib(int n) {
        if(n == 0 || n == 1)
            return n;
        return fib (n-1) + fib(n-2);
    }
}
