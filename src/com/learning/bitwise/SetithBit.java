package com.learning.bitwise;

import java.util.Scanner;

public class SetithBit {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int i = s.nextInt();
        System.out.println(turnOnIthBit(n, i));
    }

    public static int turnOnIthBit(int n, int i) {
        return n | (1 << i);
    }
}
