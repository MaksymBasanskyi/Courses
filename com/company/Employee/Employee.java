package com.company.Employee;

import java.util.ArrayList;

public class Employee
{
    private String name = null;
    private Integer rate = null;
    private Integer hours = null;

    private static ArrayList<Employee> employees = new ArrayList<>();

    public Employee()
    {
        Employee.employees.add(this);
    }

    public Employee(String name, Integer rate)
    {
        this();
        this.name = name;
        this.rate = rate;
    }

    public Employee(String name, Integer rate, Integer hours)
    {
        this(name, rate);
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public Integer getRate() {
        return rate;
    }

    public Integer getHours() {
        return hours;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public void changeRate(int rate) {
        this.rate = rate;
    }

    public Integer getSalary() throws Exception {
        if (getHours() == null) {
            throw new Exception("Hours is null");
        }
        if (getRate() == null) {
            throw new Exception("Rate is null");
        }

        return getRate() * getHours();
    }

    public Float getBonuses() throws Exception {
        return (float) (getSalary() * 0.1);
    }

    public static Integer totalSalary() {
        Integer totalSalary = 0;
        for (Employee employee: employees) {
            try {
                totalSalary += employee.getSalary();
            } catch (Throwable exception) {
                //TODO: handle exception
            }
        }

        return totalSalary;
    }
}
