package com.company.Department.Model;

public class Employee {
    private String name;
    private Integer departmentNumber;
    private Integer salary;

    public Employee(String name, Integer departmentNumber, Integer salary) {
        this.name = name;
        this.departmentNumber = departmentNumber;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Integer getDepartmentNumber() {
        return departmentNumber;
    }

    public Integer getSalary() {
        return salary;
    }
}
