package com.learning.bitwise;

import java.util.Scanner;

public class FirstSetBit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int m = 1;
        int t = 0;

        for(int i = 0; i < 32; i++) {
            if((n & (m << i)) == 0) {
                continue;
            } else {
                t =  (n & (m << i));
                break;
            }
        }
        System.out.println(t);
    }
}
