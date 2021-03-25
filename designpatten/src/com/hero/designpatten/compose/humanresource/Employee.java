package com.hero.designpatten.compose.humanresource;

/**
 * @description: Employee
 * @date: 2021/3/23 9:35
 * @author: maccura
 * @version: 1.0
 */
public class Employee extends HumanResource {

    public Employee(long id, double salary) {
        super(id);
        this.salary = salary;
    }

    @Override
    public double calculateSalary() {
       return salary;
    }
}
