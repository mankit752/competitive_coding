package com.coding_practice.bitwise;

import java.util.Scanner;

public class ClearMSB {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int i = s.nextInt();
        System.out.println(clearAllBits(n, i));
    }

    private static int clearAllBits(int n, int i) {
        int m = (1 << i) - 1;
        return n & m;
    }
}
