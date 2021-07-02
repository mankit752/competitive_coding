package com.learning.searching_and_sorting;

import java.util.Scanner;

public class MergeSort {
    public static int[] takeInput() {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = s.nextInt();
        }
        return arr;
    }

    public static void printArray(int input[]) {
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] input = takeInput();
        mergeSort(input);
        printArray(input);
    }

    private static void mergeSort(int[] input) {
        helper(input, 0, input.length -1);
    }

    public static void helper(int[] input, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            helper(input, l, mid);
            helper(input, mid + 1, r);
            merge(input, l, r, mid);
        }
    }

    public static void merge(int[] input, int l, int r, int mid) {
        int n1 = mid - l + 1;
        int n2 = r - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = input[l + i];
        }

        for (int i = 0; i < n2; i++) {
            right[i] = input[mid + 1 + i];
        }
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                input[k] = left[i];
                i++;
            } else {
                input[k] = right[j];
                j++;
            }
            k++;
        }
        while(i < n1) {
            input[k++] = left[i++];
            i++;
            k++;
        }
        while(j < n2) {
            input[k] = right[j];
            j++;
            k++;
        }
    }
}
