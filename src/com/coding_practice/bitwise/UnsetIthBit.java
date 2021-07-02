package com.coding_practice.bitwise;

import java.util.Scanner;

public class UnsetIthBit {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int i = s.nextInt();
        System.out.println(turnOffIthBit(n, i));
    }

    private static int turnOffIthBit(int n, int i) {
        if ((n & (1 << i)) != 0) {
            return n ^ (1 << i);
        } else {
            return n;
        }
    }
}
