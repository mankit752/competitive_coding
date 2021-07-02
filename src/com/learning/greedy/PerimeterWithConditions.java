package com.learning.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class PerimeterWithConditions {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Long sides[] = new Long[n];

        for (int i = 0; i < n; i++) {
            sides[i] = sc.nextLong();
        }
        Arrays.sort(sides, Collections.reverseOrder());

        Long res[] = new Long[3];
        boolean flag = false;
        long perimeter = Integer.MIN_VALUE;
        long prev = Integer.MIN_VALUE;
        for (int i = 0; i < n - 3; i++) {

            if (sides[i + 2] + sides[i + 1] > sides[i]) {
                flag = true;
                perimeter = sides[i] + sides[i + 1] + sides[i + 2];
                if (perimeter > prev) {
                    prev = perimeter;
                    res[0] = sides[i];
                    res[1] = sides[i + 1];
                    res[2] = sides[i + 2];
                } else if (perimeter == prev && res[0] < sides[i]) {
                    prev = perimeter;
                    res[0] = sides[i];
                    res[1] = sides[i + 1];
                    res[2] = sides[i + 2];
                } else if (perimeter == prev && res[2] < sides[i + 2]) {
                    prev = perimeter;
                    res[0] = sides[i];
                    res[1] = sides[i + 1];
                    res[2] = sides[i + 2];
                }

            }
            }

            if(flag == false) {
                System.out.println("-1");
            }
            else {
                System.out.println(res[2] + " " + res[1] + " " +res[0]);
            }
    }
}
