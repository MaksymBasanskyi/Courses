package com.company.Department.Component;

import com.company.DataManagement.Component.OutputInterface;
import com.company.Department.Model.Employee;
import com.company.Lib.Component.TaskInterface;
import com.company.Lib.Dao.RepositoryInterface;

import java.util.List;
import java.util.stream.Collectors;

public class DepartmentTask implements TaskInterface {
    private RepositoryInterface<Employee> employeeRepository;
    private RepositoryInterface<Integer> integerRepository;
    private OutputInterface output;

    public DepartmentTask(RepositoryInterface<Employee> employeeRepository, RepositoryInterface<Integer> integerRepository, OutputInterface output) {
        this.employeeRepository = employeeRepository;
        this.integerRepository = integerRepository;
        this.output = output;
    }

    public void run() {
        List<Employee> employees = employeeRepository.takeList(5);
        output.publishRow("Please provide department number");
        Integer needle = integerRepository.take();

        List<Employee> employeesInDepartment = employees.stream()
                .filter(employee -> employee.getDepartmentNumber()
                .equals(needle))
                .collect(Collectors.toList());
        output.publishRow(String.format(
                "Employees in %d department:\n%s",
                needle,
                employeesInDepartment.stream().map(Employee::getName).collect(Collectors.joining(", "))
        ));
        employees.sort((o1, o2) -> o2.getSalary() - o1.getSalary());
        output.publishRow(String.format(
                "Employees by salary:\n%s",
                employees.stream()
                        .map(employee -> "\t" + employee.getName() + " " + employee.getSalary())
                        .collect(Collectors.joining("\n"))
        ));
    }
}
