package com.coding_practice.more_adhoc;

import java.util.Scanner;

public class RopeCutting {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int input = s.nextInt();
        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();

        int max = cut(input, a, b, c);
        System.out.println(max);
    }

    private static int cut(int input, int a, int b, int c) {
        if(input == 0) {
            return 0;
        }
        if(input < 0) {
            return -1;
        }
        int res = Math.max(cut(input-a, a, b, c ), Math.max(cut(input-b, a, b, c ), cut(input-c, a, b, c )));
        if(res >= 0) {
            res += 1;
        }
        return res;
    }
}
