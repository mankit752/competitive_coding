package com.coding_practice.more_adhoc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MarksCount2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Student> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String name = sc.next();
            int m1 = sc.nextInt();
            int m2 = sc.nextInt();
            int m3 = sc.nextInt();

            Student student = new Student(name, m1+m2+m3);
            list.add(student);

        }
        Collections.sort(list, Student.StuNameComparator);
        int rank = 1;
        for(Student str: list){
            System.out.print(rank++ + " ");
            System.out.print(str.getName());
            System.out.println();
        }




    }

    public static class Student {
        private String name;
        private int marks;

        public Student(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getMarks() {
            return marks;
        }

        public void setMarks(int marks) {
            this.marks = marks;
        }

        public static Comparator<Student> StuNameComparator = (s1, s2) -> {
            int marks1 = s1.getMarks();
            int marks2 = s2.getMarks();
            return marks2 - marks1;
        };
        @Override
        public String toString() {
            return name;
        }
    }
}
