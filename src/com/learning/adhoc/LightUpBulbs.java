package com.learning.adhoc;

import java.util.Scanner;

public class LightUpBulbs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long x = sc.nextLong();
        long y = sc.nextLong();

        String s = sc.next();
        int numOfZeroGroups = 0;
        if (s.charAt(0) == '0') {
            numOfZeroGroups = 1;
        }

        for (int i = 0, j = 1; j < n; i++, j++) {
            if (s.charAt(i) == '1' && s.charAt(j) == '0') {
                numOfZeroGroups++;
            }
        }

        if(!s.contains("1")) {
            System.out.println(y);
            return;
        }
        if (numOfZeroGroups == 0) {
            System.out.println(0);
        } else {
            System.out.println((numOfZeroGroups-1) * Math.min(x, y) + y);
        }

        return;
    }
}
