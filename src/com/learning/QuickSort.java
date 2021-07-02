package com.learning;

import java.util.Scanner;

public class QuickSort {
    static Scanner s = new Scanner(System.in);

    public static int[] takeInput() {
        int size = s.nextInt();
        int[] input = new int[size];
        for (int i = 0; i < size; i++) {
            input[i] = s.nextInt();
        }
        return input;
    }

    public static void main(String[] args) {
        int[] input = takeInput();
        quickSort(input);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }

    private static void quickSort(int[] input) {
        int l = 0;
        int h = input.length - 1;
        qsort(input, l, h);
    }

    private static void qsort(int[] input, int l, int h) {
        if (l < h) {
            int p = partition(input, l, h);
            qsort(input, l, p - 1);
            qsort(input, p + 1, h);
        }
    }

    private static int partition(int[] input, int l, int h) {
        int i = l - 1;
        int p = input[h];
        for (int j = l; j < h; j++) {
            if (input[j] < p) {
                i++;
                swap(input, i, j);
            }
        }
        swap(input, i + 1, h);
        return i + 1;
    }

    private static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
