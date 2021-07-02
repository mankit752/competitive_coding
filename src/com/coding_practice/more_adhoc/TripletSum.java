package com.coding_practice.more_adhoc;

import java.util.Arrays;
import java.util.Scanner;

public class TripletSum {
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
        Arrays.sort(arr);
        //System.out.println("Sorted Array = " + Arrays.toString(arr));
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int start = i + 1, end = n - 1;
            int sum = x - arr[i];
            while (start < end) {
                if (arr[start] + arr[end] < sum) {
                    start++;
                } else if (arr[start] + arr[end] > sum) {
                    end--;
                }
                else {
                    int count1 = 0, count2 = 0;
                    for(int j = start; j <= end; j++) {
                        if(arr[j] == arr[start])
                            count1++;
                        else
                            break;
                    }
                    for(int j = end; j >= start; j--) {
                        if(arr[j] == arr[end])
                            count2++;
                        else
                            break;
                    }
                    int count = count1 * count2;
                    if(arr[start] == arr[end]) {
                        count = ((end - start +1) * (end - start))/2;
                    }
                    for(int k = 0; k < count; k++) {
                        System.out.println(arr[i] + " " + arr[start] + " " + arr[end]);
                    }
                    start = start +count1;
                    end = end - count2;

                }
            }


        }
    }
}
