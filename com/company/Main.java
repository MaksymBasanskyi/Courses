package com.company;

import com.company.Employee.Employee;
import com.company.Person.Person;

public class Main
{
    public static void main(String[] args) throws Exception {
        String taskType = null;
        if (args.length == 0) {
            taskType = "person";
        } else {
            taskType = args[0];
        }

        switch (taskType) {
            case "employee":
                employeeTask();
                break;
            case "person":
                PersonTask();
                break;
            default:
                throw new Exception(String.format("Unknown Task %s", taskType));
        }
    }

    private static void employeeTask() {
        Employee employeeJohn = new Employee();
        employeeJohn.setHours(40);
        employeeJohn.setRate(9);
        employeeJohn.setName("John");
        Employee employeeMarta = new Employee("Marta", 10);
        employeeMarta.setHours(38);
        Employee employeeDan = new Employee("Dan", 4, 98);
        System.out.println(String.format("Total Salary of all workers: %d", Employee.totalSalary()));
        employeeDan.changeRate(7);
        System.out.println(String.format("Total Salary of all workers after Dan's raise: %d", Employee.totalSalary()));
    }

    private static void PersonTask() throws Exception {
        Person person1 = Person.input();
        person1.output();
        Person person2 = Person.input();
        person2.output();
        Person person3 = Person.input();
        person3.output();
        Person person4 = Person.input();
        person4.output();
        Person person5 = Person.input();
        person5.output();
    }
}
