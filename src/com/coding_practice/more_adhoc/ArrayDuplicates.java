package com.coding_practice.more_adhoc;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ArrayDuplicates {


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
        System.out.print(duplicate(arr));
    }

    public static int duplicate(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            if(set.contains(arr[i])) {
                return arr[i];
            }
            set.add(arr[i]);
        }
        return 0;
    }
}
