package com.hero.designpatten.compose.humanresource;

/**
 * @description: HumanResource
 * @date: 2021/3/23 9:34
 * @author: maccura
 * @version: 1.0
 */
public abstract class HumanResource {
    protected long id;
    protected double salary;

    public HumanResource(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }
    public abstract double calculateSalary();
}
