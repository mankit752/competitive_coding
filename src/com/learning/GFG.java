package com.learning;

import java.util.ArrayList;
import java.util.List;

class GFG
{

    // Driver code
    public static void main (String[] args)
    {
        int a = 2;
        int b = 3;
        double c = (double)a/b;

        List<Boolean> primes = new ArrayList<>();

        primes.add(0,true);
        primes.set(0, false);
        /*System.out.println(findDigits(1));
        System.out.println(findDigits(5));*/
        System.out.println(c);
        //System.out.println(findDigits(120));
    }
}
