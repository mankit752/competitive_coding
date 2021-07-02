package com.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {


    static Scanner s = new Scanner(System.in);

    public static int[] takeInput(){
        int size = s.nextInt();
        int[] input = new int[size];
        for(int i = 0; i < size; i++){
            input[i] = s.nextInt();
        }
        return input;
    }

    public static void main(String[] args) {
        int[] input = takeInput();
        int x = s.nextInt();
        int output[] = Solution.allIndexes(input, x);
        for(int i = 0; i < output.length; i++) {
            System.out.print(output[i] + " ");
        }
    }
    public static int[] allIndexes(int input[], int x) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        int size = input.length;
        int res[] = new int[5];
        Arrays.fill(res, -1);
        res = helper(input, x, size-1, res, 0, 0);
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            if(res[i] == -1) {
                break;
            }
            temp.add(i, res[i]);
        }
        int[] arr = temp.stream().mapToInt(i->i).toArray();
        return arr;

    }

    private static int[] helper(int input[], int x, int size, int res[], int i, int c) {
        if(input[i] == x && i == size) {
            res[c] = i;
            c++;
            //System.out.println("c1 = " + c);
            return res;
        }
        else if(input[i] != x && i == size) {
            return res;
        }
        else if(input[i] == x && i != size) {
            res[c] = i;
            c++;
            //System.out.println("c2 = " + c);
        }
        return helper(input, x, size, res, i+1, c);

    }

}
