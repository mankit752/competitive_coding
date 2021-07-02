package com.coding_practice.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MaximumActivity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        MyCmp comp = new MyCmp();

        Activity[] act = new Activity[n];
        for(int i = 0; i < n; i++) {
            int st = sc.nextInt();
            int end = sc.nextInt();
            Activity t = new Activity(st, end);
            act[i] = t;
        }

        Arrays.sort(act, comp);

        int res = 1;
        int last = 0;
        for(int i = 1; i < n; i++) {
            if(act[i].start >= act[last].finish) {
                res++;
                last = i;
            }
        }
        System.out.println(res);
        return;
    }


}

class Activity {
    int start;
    int finish;

    public Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}

class MyCmp implements Comparator<Activity> {

    @Override
    public int compare(Activity o1, Activity o2) {
        /*int t = o1.finish - o2.finish;
        if(t != 0) {
            return t;
        } else {
            return o1.start - o2.start;
        }*/
        return o1.finish - o2.finish;
    }
}
