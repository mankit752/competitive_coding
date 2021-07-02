package com.coding_practice.more_adhoc;

import java.util.*;

public class Permpal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        while(T-- > 0) {
            String s = sc.next();
            findPalindrome(s);
            System.out.println();
        }
    }

    private static void findPalindrome(String s) {
        Map<Character, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            Character temp = s.charAt(i);
            if(map.containsKey(temp)) {
                ArrayList<Integer> list;
                list = map.get(temp);
                list.add(i);
                map.put(temp, list);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(temp, list);
            }
        }

        int countOdd = 0;
        for (Map.Entry<Character,ArrayList<Integer>> entry : map.entrySet()) {
            if(entry.getValue().size() % 2 == 1) {
                countOdd++;
            }
        }

        if(countOdd >= 2) {
            System.out.print("-1");
            return;
        }

        int[] res = new int[s.length()];
        int start = 0, end = s.length() -1;

        Iterator <Character> it = map.keySet().iterator();

        while (it.hasNext()) {
           // Character key = it.next();
            ArrayList<Integer> values = map.get(it.next());
            for(int j = 0; j < values.size(); j+=2) {
                if(values.size() - j == 1) {
                    res[s.length()/2] = values.get(j);
                    continue;
                }
                res[start++] = values.get(j);
                res[end--] = values.get(j+1);

            }
        }
        for (Integer i: res) {
            System.out.print(i+1 + " ");

        }
        return;
    }
}
