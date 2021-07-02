package com.learning;

import java.util.*;

public class Count {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String st = in.nextLine();
        Map<String, Integer> map = new HashMap<>();
        String []parsed = st.split(" ");
        System.out.println(Arrays.toString(parsed));

        for (String s: parsed)  {
            map.putIfAbsent(s, 0);
            map.put(s, map.get(s) + 1);
        }

        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        int flag = 0;
        for (Map.Entry<String, Integer> entry : temp.entrySet()) {
            if(entry.getValue() > 1) {
                flag = 1;
            }
            if(entry.getValue() >= 2)
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        if(flag == 0) {
            System.out.println("-1");
        }
    }
}
