package com.learning;

import java.util.Arrays;
import java.util.Scanner;

public class MaxGuests {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        int[] dep = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++) {
            dep[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 1, j = 0, curr = 1, res = 1;

        while(i < n && j < n) {
            if(arr[i] < dep[j]) {
                curr++;
                i++;
            }
            else {
                curr--;
                j++;
            } res = Math.max(curr, res);
        }
        System.out.println(res);
    }
}
