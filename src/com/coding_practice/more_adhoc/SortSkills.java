package com.coding_practice.more_adhoc;

import java.util.Scanner;

public class SortSkills {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] skills = new int[n];
            for (int i = 0; i < n; i++) {
                skills[i] = sc.nextInt();
            }

            for (int i = 1; i < n; i++) {
                if(skills[i - 1] - skills[i] == 1) {
                    swap(skills, i, i - 1);
                }
            }

            /*for(int i = 0; i<n; i++) {
                System.out.print(skills[i] + "  ");
            }*/

            int flag = 0;
            for (int i = 1; i < n; i++) {
                if(skills[i] < skills[i-1]) {
                    flag = 1;
                    System.out.println("false");
                    break;
                }
            }
            if(flag == 0)
                System.out.println("true");
        }
    }

    private static void swap(int[] skills, int i, int j) {
        int temp = skills[i];
        skills[i] = skills[j];
        skills[j] = temp;
    }
}
