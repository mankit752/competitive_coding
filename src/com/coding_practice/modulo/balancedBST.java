package com.coding_practice.modulo;

import java.util.Scanner;

public class balancedBST {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int height = s.nextInt();
        System.out.println(balancedTreesOfHeightH(height));
    }

    private static int balancedTreesOfHeightH(int height) {
        int t = (int) Math.pow(10, 9) + 7;
        if (height == 1 || height == 0) {
            return 1;
        }
        int x = balancedTreesOfHeightH(height - 1);
        int y = balancedTreesOfHeightH(height - 2);

        long res1 = (long)x * x;
        long res2 = (long)2 * x * y;

        int ans1 = (int) (res1 % t);
        int ans2 = (int) (res2 % t);

        return (ans1 + ans2) % t;

    }
}
