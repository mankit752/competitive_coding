package com.coding_practice.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FractionalKnapsack {
    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long d = sc.nextLong();

        Worker[] w = new Worker[n];
        MyCompWorker comp = new MyCompWorker();

        for (int i = 0; i < n; i++) {
            int time = sc.nextInt();
            int cost = sc.nextInt();
            int speed = sc.nextInt();

            Worker w1 = new Worker(time, cost, speed);
            w[i] = w1;
        }

        Arrays.sort(w, comp);

        long cost = 0;
        long units = 0;
        long lastTime = w[0].time;
        long bestSpeed = 0;

        for (int i = 0; i < n; i++) {
            units += (bestSpeed * (w[i].time - lastTime));
            if (units >= d) {
                break;
            }
            if (w[i].speed > bestSpeed) {
                bestSpeed = w[i].speed;
                cost += w[i].cost;
            }
            lastTime = w[i].time;
        }
        System.out.println(cost);
        return;

    }
}


class Worker {
    int time;
    int cost;
    int speed;

    public Worker(int time, int cost, int speed) {
        this.time = time;
        this.cost = cost;
        this.speed = speed;
    }
}

class MyCompWorker implements Comparator<Worker> {

    @Override
    public int compare(Worker o1, Worker o2) {
        if (o1.time == o2.time) {
            if(o1.speed == o2.speed) {
                return o1.cost - o2.cost;
            }
            return o2.speed - o1.speed;
        }
        return o1.time - o2.time;
    }
}
