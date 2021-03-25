package com.hero.designpatten.compose.humanresource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: Department
 * @date: 2021/3/23 9:39
 * @author: maccura
 * @version: 1.0
 */
public class Department extends HumanResource {
    private List<HumanResource> subNodes = new ArrayList<>();

    public Department(long id) {
        super(id);
    }

    @Override
    public double calculateSalary() {
        double totalSalary = 0;
        for (HumanResource hr : subNodes) {
            totalSalary += hr.calculateSalary();
        }

        this.salary = totalSalary;
        return totalSalary;
    }

    public void addSubNode(HumanResource hr) {
        subNodes.add(hr);
    }

    List<Long> getSubDepartmentIds() {
        return subNodes.stream().map(HumanResource::getId).collect(Collectors.toList());
    }

}
