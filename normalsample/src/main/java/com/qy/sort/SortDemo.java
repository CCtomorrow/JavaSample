package com.qy.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * <b>Project:</b> Sample <br>
 * <b>Create Date:</b> 2018/3/20 <br>
 * <b>@author:</b> qy <br>
 * <b>Address:</b> qingyongai@gmail.com <br>
 * <b>Description:</b>  <br>
 */
public class SortDemo {

    public static class Student implements Comparable<Student> {
        public String name;
        public int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Student o) {
            // 小的在前面
            if (this.age > o.age) {
                return 1;
            } else if (this.age < o.age) {
                return -1;
            }
            return 0;
        }
    }

    public static void main(String[] ss) {
        Student student = new Student("的", 23);
        Student student2 = new Student("都", 22);

        ArrayList<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student2);
//        students.sort(new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                if (o1.age > o2.age) {
//                    return 1;
//
//                } else if (o1.age < o2.age) {
//                    return -1;
//                }
//                return 0;
//            }
//        });
        System.out.println(students.size());
    }
}
