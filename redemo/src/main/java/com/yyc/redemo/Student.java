package com.yyc.redemo;

/**
 * @author: yaoyongchao
 * @date: 2017/2/8 13:54
 * @description:
 */

public class Student implements Comparable<Student> {
    public String name;
    public int age;
    public int wight;

    public Student(String name, int age, int wight) {
        this.name = name;
        this.age = age;
        this.wight = wight;
    }

    @Override
    public int compareTo(Student o) {
        if(this.age > o.age)
            return 1;
        if(this.age < o.age) {
            return -1;
        }else {
            return 0;
        }
    }
}
