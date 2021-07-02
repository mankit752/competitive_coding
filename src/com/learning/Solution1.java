package com.learning;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Solution1 {
    public static int storageOptimization(int h, int v, Integer[] hc, Integer[] vc) {
        // track all missing elements
        boolean[] hc_missing = new boolean[h];
        boolean[] vc_missing = new boolean[v];

        // mark all elements which are missing in given array
        for(int cut : hc) hc_missing[cut - 1] = true;
        for(int cut : vc) vc_missing[cut - 1] = true;

        // calculate horizontal max missing length
        int h_max = 0;
        for(int i = 0, j = 0; i < h; i++) {
            if(!hc_missing[i]) j = 0;
            else {
                j++;
                h_max = Math.max(h_max, j);
            }
        }

        // calculate vertical max missing length
        int v_max = 0;
        for(int i = 0, j = 0; i < v; i++) {
            if(!vc_missing[i]) j = 0;
            else {
                j++;
                v_max = Math.max(v_max, j);
            }
        }

        // since it could be a large number get the mod 10e7
        return  (((h_max + 1 ) * (v_max +1)) % 1000000007);

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        List<Integer> h = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> v = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        Integer[] hc = new Integer[h.size()];
        Integer[] vc = new Integer[v.size()];
        h.toArray(hc);
        v.toArray(vc);
        int res = storageOptimization(n, m, hc, vc);
        System.out.println(res);
    }
}

