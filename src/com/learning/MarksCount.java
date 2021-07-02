package com.learning;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MarksCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        int n = sc.nextInt();
        for(int i = 0; i< n; i++) {
            String name = sc.next();
            int m1 = sc.nextInt();
            int m2 = sc.nextInt();
            int m3 = sc.nextInt();

            map.put(name, m1+m2+m3);
        }

        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        LinkedHashMap<String, Integer> temp = new LinkedHashMap<>();
        for(Map.Entry<String, Integer> aa: list) {
            temp.put(aa.getKey(), aa.getValue());
        }

        int rank = 1;
        for (Map.Entry<String, Integer> en : temp.entrySet()) {
            System.out.println(rank++ + " " + en.getKey());
        }
    }
}
