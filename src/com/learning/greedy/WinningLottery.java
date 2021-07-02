package com.learning.greedy;

import java.util.Scanner;

public class WinningLottery {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        int d = sc.nextInt();

        int res[] = new int[d];

        for (int i = d - 1; i >= 0; i--) {
            if(sum > 9) {
                res[i] = 9;
                sum -= 9;
                continue;
            } else if(sum == 9 && i == 0) {
                res[i] = 9;
            } else if(sum <= 9 & i > 0) {
                res[i] = sum - 1;
                i--;
                while(i > 0) {
                    res[i] = 0;
                    i--;
                }
                res[i] = 1;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < d; i++) {
            sb.append(res[i]);
        }
        System.out.println(sb);
    }
}
