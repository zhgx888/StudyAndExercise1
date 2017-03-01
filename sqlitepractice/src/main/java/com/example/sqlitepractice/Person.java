package com.example.sqlitepractice;

/**
 * Created by Administrator on 2017/1/3 0003.
 */

public class Person {
    public String name;
    public String id;
    public int age;
    public String info;

    public Person(String name, int age, String info) {
        this.name = name;
        this.age = age;
        this.info = info;
    }
    public Person(String name, String info) {
        this.name = name;

        this.info = info;
    }

    public Person(String name, String id, int age, String info) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.info = info;
    }

    @Override
    public String toString() {
        return "Person{" +"name='" + name + '\'' +", id='" + id + '\'' +", age=" + age + ", info='" + info +'}'+"\n";
    }
}
