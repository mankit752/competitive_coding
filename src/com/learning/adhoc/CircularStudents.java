package com.learning.adhoc;

import java.util.Scanner;

public class CircularStudents {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int i = sc.nextInt();
            int p = sc.nextInt();
            //int x = p%11;

            System.out.println((i + p)%12);
        }

    }
}
