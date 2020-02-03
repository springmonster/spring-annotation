package com.kuang.bean;

import org.springframework.beans.factory.annotation.Value;

public class Person {
    @Value("#{20-2}")
    private int age;
    @Value("张三")
    private String name;
    @Value("${person.nickName}")
    private String nickName;

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person(int age, String name, String nickName) {
        this.age = age;
        this.name = name;
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
