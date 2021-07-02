package com.learning;

import java.util.Scanner;

public class FIndUnique {

    public static int[] takeInput() {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = s.nextInt();
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = takeInput();
        System.out.print(findUnique(arr));
    }

    public static int findUnique(int[] arr) {
        /* Your class should be named FindUnique
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        int xor = arr[0];
        for (int i = 1; i < arr.length; i++) {
            xor ^= arr[i];
        }
        return xor;

    }
}
