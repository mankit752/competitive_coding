package com.learning;

import java.util.Scanner;

public class SumMeUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0) {
            long n = sc.nextLong();
            long sum = 0;
            while(n != 0) {
                sum += n%10;
                n /= 10;
            }
            System.out.println(sum);
        }

    }
}
