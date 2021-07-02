package com.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int arr[] = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        ArrayList<Integer> ans = longestConsecutiveIncreasingSequence(arr);
        for(int num: ans) {
            System.out.println(num);
        }
    }

    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        int count = 1;
        int index = 0;
        int max = 1;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == (arr[i-1] +1)) {
                count++;
                if(count > max) {
                    max = count;
                    index = i - max +1;
                }
            } else {
                count = 1;
            }
        }
        for(int i = 0; i < max; i++) {
            list.add(arr[index +i]);
        }
        return list;
    }


}
