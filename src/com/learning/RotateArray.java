package com.learning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RotateArray {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int[] takeInput() throws IOException {
        int size = Integer.parseInt(br.readLine().trim());
        int[] input = new int[size];

        if (size == 0) {
            return input;
        }

        String[] strNums;
        strNums = br.readLine().split("\\s");


        for (int i = 0; i < size; ++i) {
            input[i] = Integer.parseInt(strNums[i]);
        }

        return input;
    }

    public static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        int t = Integer.parseInt(br.readLine().trim());

        while(t > 0) {

            int[] input = takeInput();
            int d = Integer.parseInt(br.readLine().trim());
            rotate(input, d);
            printArray(input);

            t -= 1;
        }
    }

    private static void rotate(int[] input, int d) {
        int mod = d % input.length;
        int[] temp = new int[mod];
        for(int i = 0; i < mod; i++) {
            temp[i] = input[i];
        }
        for(int i = mod; i < input.length; i++) {
            input[i - mod] = input[i];
        }
        for(int i = input.length - mod, j=0; i < input.length; i++,j++) {
            input[i] = temp[j];
        }
    }
}
