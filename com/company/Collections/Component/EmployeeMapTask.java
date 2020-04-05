package com.company.Collections.Component;

import com.company.DataManagement.Component.OutputInterface;
import com.company.Lib.Component.TaskInterface;
import com.company.Lib.Dao.RepositoryInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeMapTask implements TaskInterface {

    private RepositoryInterface<Integer> integerRepository;
    private RepositoryInterface<String> stringRepository;
    private OutputInterface output;

    public EmployeeMapTask(RepositoryInterface<Integer> integerRepository, RepositoryInterface<String> stringRepository, OutputInterface output) {
        this.integerRepository = integerRepository;
        this.stringRepository = stringRepository;
        this.output = output;
    }

    @Override
    public void run() {
        HashMap<Integer, String> employeeMap = new HashMap<>();
        for (int i = 0; i < 7; i++) {
            output.publishRow("Employee Id");
            Integer id = integerRepository.take();
            output.publishRow("Employee name");
            String name = stringRepository.take();
            employeeMap.put(id, name);
        }
        output.publishRow(employeeMap.entrySet().stream().map(entry -> entry.getKey() + ":" + entry.getValue()).collect(Collectors.joining(";")));
        output.publishRow("provide id:");
        Integer needleId = integerRepository.take();
        if (employeeMap.containsKey(needleId)) {
            output.publishRow(String.format("Employee name %s", employeeMap.get(needleId)));
        } else {
            output.publishRow(String.format("No employee with id: %d", needleId));
        }
        output.publishRow("provide name:");
        String needleName = stringRepository.take();
        if (employeeMap.containsValue(needleName)) {
            for (Map.Entry<Integer, String> entry : employeeMap.entrySet()) {
                if (entry.getValue().equals(needleName)) {
                    output.publishRow(String.format("Employee id %d", entry.getKey()));
                }
            }
        } else {
            output.publishRow(String.format("No employee with name: %s", needleName));
        }
    }
}
