package com.learning;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HussainSet {
    public static void main(String[] args) throws java.lang.Exception {

        Scanner sc = new Scanner(System.in);
        int N, M;
        N = sc.nextInt();
        M = sc.nextInt();

        long[] input = new long[N];
        int q;
        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }

        Queue<Long> queue = new LinkedList<>();

        Arrays.sort(input);
        int end = N - 1;
        int count = 0;
        long ans = 0;
        for(int j = 0; j < M; j++) {
            q = sc.nextInt();

            for (; count < q; count++) {
                if (end >= 0 && (queue.isEmpty() || input[end] >= ((LinkedList<Long>) queue).getFirst())) {
                    ans = input[end];
                    end--;
                } else {
                    ans = ((LinkedList<Long>) queue).getFirst();
                    ((LinkedList<Long>) queue).pop();
                }
                    ((LinkedList<Long>) queue).addLast(ans/2);
            }
            System.out.println(ans);
        }
try {

} catch (Exception e) {
            e.printStackTrace();
}

    }
}
