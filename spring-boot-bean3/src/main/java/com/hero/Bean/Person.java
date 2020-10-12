package com.hero.Bean;

/**
 * @description: Person
 * @date: 2020/10/11
 * @author: bear
 * @version: 1.0
 */
public class Person {
    private String name;

    public Person() {
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
                "name='" + name + '\'' +
                '}';
    }
}
