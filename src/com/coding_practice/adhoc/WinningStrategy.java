package com.coding_practice.adhoc;

import java.util.Scanner;

public class WinningStrategy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        int swaps = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++) {
            if(arr[i] > (i+1)) {
                if(arr[i] - i > 3) {
                    System.out.println("NO");
                    return;
                }
                else {
                    swaps += arr[i] - (i+1);
                }
            }
        }
        System.out.println("YES");
        System.out.println(swaps);
    }
}
