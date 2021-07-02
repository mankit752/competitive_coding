package com.learning;

public class Test {

    static int gcd(int a, int b) {
        if(a == 0)
            return b;
        return gcd(b % a, a);
    }

    static int numberOfTrailingZeroes (int n) {
        int count = 0;
        for(int i = 5; n/i >= 1; i *= 5) {
            count += n/i;
        }
        return count;
    }
    public static void main(String [] args) {
        /*System.out.println(gcd(10, 14));
        System.out.println(numberOfTrailingZeroes(36));*/

        String s = "abc";
        String b = "abc";

        /*System.out.println(s.hashCode());
        System.out.println(b.hashCode());*/
        int a = 10;
        int z = 20;
        String t = a + "-" + z;
        System.out.println(t);
    }
}

