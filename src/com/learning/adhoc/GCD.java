package com.learning.adhoc;

import java.util.Scanner;

public class GCD {
    static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    // Driver method
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(a > b) {
            a = a + b;
            b = a - b;
            b = a - b;
        }
        System.out.println("GCD of " + a +" and " + b + " is " + gcd(a, b));
    }
}
