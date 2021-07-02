package com.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Voters {
    public static void main(String[] args) {
        int N1, N2, N3;
        Scanner sc = new Scanner(System.in);
        N1 = sc.nextInt();
        N2 = sc.nextInt();
        N3 = sc.nextInt();
        int t = N1 + N2 + N3;
        int[] input = new int[t];

        for (int i = 0; i < t; i++) {
            input[i] = sc.nextInt();
        }

        Arrays.sort(input);
        //System.out.println("Input = " + Arrays.toString(input));
        List<Integer> list = voters(input, t);
        System.out.println(list.size());
        for (Integer i: list){
                System.out.println(i);

        }


    }

    public static ArrayList voters(int []input, int t) {
        ArrayList list = new ArrayList();
        for (int i = 0; i < t;) {
            int count = 0;
            int temp = i;
            while (temp < t && input[i] == input[temp]) {
                count++;
                temp++;
            }
            if(count >= 2) {
                list.add(input[i]);

            }
            i = temp;
        }
        return list;
    }
}
