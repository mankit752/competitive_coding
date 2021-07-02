package com.learning;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class PairSum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        pairSum(arr, n);
    }

    private static void pairSum(int[] arr, int n) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(arr[i], 0);
            map.put(arr[i], map.get(arr[i]) + 1);
        }

        Set<Integer> entry = map.keySet();
        List<Integer> list = new ArrayList<Integer>(entry);

        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            int rem = 0 - list.get(i);
            if (map.get(rem) != null) {
                count = map.get(rem) * map.get(list.get(i));
            }
            while (count > 0) {
                System.out.println(list.get(i) + " " + rem);
                count--;
            }
            map.put(list.get(i), 0);
            map.put(rem, 0);
        }

        /*int start = 0, end = n-1;
        while(start < end) {
            if(arr[start] + arr[end] == 0 ) {
                System.out.println(arr[start] + " " + arr[end]);
                while(start < end && arr[start] == arr[start +1]) {
                    System.out.println(arr[start] + " " + arr[end]);
                    start++;
                }
                while(start < end && arr[end] == arr[end -1]) {
                    System.out.println(arr[start] + " " + arr[end]);
                    end--;
                }
                start++;
                end--;
            }
            else if(arr[start] + arr[end] > 0) {
                end--;
            } else {
                start++;
            }
        }*/
    }
}
