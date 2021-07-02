package com.learning;

import java.util.Arrays;

public class ArraySum {
    public static void main(String[] args) {
        int [] arr = {9, 8, 9};
        System.out.println(arr.length);

        int [] a = Arrays.copyOf(arr, arr.length - 1);

        System.out.println(Arrays.toString(a));

        //Arrays.copyOfRange(arr, )
        //System.arraycopy(arr, );

        int res[] = new int[]{};

        System.out.println(sum(arr));
    }

    public static int sum(int input[]) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */


        int l = input.length - 1;
        if(l == 0) {
            return input[0];
        }

        return input[l] + sum(Arrays.copyOf(input, l));
    }
}
