package com.coding_practice.more_adhoc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class LongestConsecutiveSequence2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        ArrayList<Integer> ans = longestConsecutiveIncreasingSequence(arr);
        for (int num : ans) {
            System.out.println(num);
        }
    }

    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
        HashMap<Integer, Boolean> map = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], true);
        }

        int count = 1;

        for(int val: arr) {
            if(map.containsKey(val -1)) {
                map.put(val, false);
            }
        }
        int msp = 0;
        int ml = 0;
        for(int val: arr) {
            int tl = 1;
            int tsp = val;
            if(map.get(val) == true) {
                while(map.containsKey(tsp +tl)) {
                    tl++;
                }
            }
            if(tl > ml) {
                ml = tl;
                msp = tsp;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < ml; i++) {
            list.add(msp+i);
        }
        return list;
    }
}
