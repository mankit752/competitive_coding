package com.coding_practice.more_adhoc;

import java.util.*;

public class TripletSum2 {

    static Scanner s = new Scanner(System.in);

    public static int[] takeInput() {
        int size = s.nextInt();
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = s.nextInt();
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = takeInput();
        int num = s.nextInt();
        FindTriplet(arr, num);
    }

    public static void FindTriplet(int[] arr, int x) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i], 0);
            map.put(arr[i], map.get(arr[i]) + 1);
        }
        //map.forEach((k, v) -> System.out.println((k + " : " + v)));

        Set<Integer> keySet = map.keySet();
        List<Integer> list = new ArrayList<>(keySet);
        Collections.sort(list);

        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            int start = i + 1;
            int end = n - 1;
            int temp = list.get(i);

            while (start < end) {
                if (temp + list.get(start) + list.get(end) == x) {
                    int count = map.get(list.get(start)) * map.get(list.get(end)) * map.get(temp);
                    while (count > 0) {
                        System.out.println(temp + " " + list.get(start) + " " + list.get(end));
                        count--;
                    }
                    start++;
                    end--;
                } else if (temp + list.get(start) + list.get(end) < x) {
                    start++;
                } else if (temp + list.get(start) + list.get(end) > x) {
                    end--;
                }
            }
            if (start == end && (temp + list.get(start) + list.get(end) ==x) ) {
                int c = map.get(list.get(start));
                int count = (c * c-1)/2 * map.get(temp);
                /*if(map.get(list.get(start)) > map.get(temp)) {
                    count = (map.get(list.get(start)) - map.get(temp)) * (map.get(list.get(start)) / 2);
                }
                else if(map.get(list.get(start)) < map.get(temp) && map.get(temp)> 2) {
                    count = (map.get(list.get(start)) * map.get(temp))/2;
                }*/

            }
        }

    }
}
