package com.coding_practice.searching_and_sorting;

import java.util.*;

public class ChefRes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int m, n;
            n = sc.nextInt();
            m = sc.nextInt();

            List<Intervals> time = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int val1 = sc.nextInt();
                int val2 = sc.nextInt();
                Intervals interval = new Intervals(val1, val2);
                time.add(interval);
            }

            Collections.sort(time, Intervals.IntervalsComparator);
            //System.out.println("Sorted List = " + time.toString());

            String s = "";
            while (m-- >0) {
                int currTime = sc.nextInt();
                int res = computeWaitTime(time, currTime);
                s += res + "\n";
            }
            System.out.println(s);

        }
    }

    private static int computeWaitTime(List<Intervals> time, int currTime) {
        int res = -1;
        int l = 0;
        int r = time.size()-1;

        while(l <= r) {
            int m = l + (r - l)/2;
            if(currTime < time.get(m).getEnd()) {
                res = Math.max(0, time.get(m).getStart() - currTime);
                r = m - 1;
                if(res == 0)
                    break;
            } else {
                l = m+1;
            }
        }
        return res;
    }

    public static class Intervals {
        int start;
        int end;

        public Intervals(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public static Comparator<Intervals> IntervalsComparator = Comparator.comparingInt(Intervals::getStart);

        @Override
        public String toString() {
            return "Intervals{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
