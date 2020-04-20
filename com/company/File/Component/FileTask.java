package com.company.File.Component;

import com.company.DataManagement.Component.OutputInterface;
import com.company.Lib.Component.TaskInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FileTask implements TaskInterface {
    private OutputInterface output;
    private String filePath;

    public FileTask(OutputInterface output, String filePath) {
        this.output = output;
        this.filePath = filePath;
    }

    @Override
    public void run() {
        List<String> rows = readFile(filePath);
        if (rows.size() != 0) {
            rows.forEach(s -> output.publishRow((String.valueOf(s.length()))));
            rows.sort(Comparator.comparingInt(String::length));
            output.publishRow(String.format("Longest Line: %s%nShortest line %s%n", rows.get(rows.size() - 1), rows.get(0)));
            rows.stream().filter(s -> s.contains("var")).forEach(output::publishRow);
        } else {
            output.publishRow("empty list");
        }
    }

    private List<String> readFile(String fileName) {
        List<String> rows = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String row;
            while ((row = bufferedReader.readLine()) != null) {
                rows.add(row);
            }
        } catch (IOException e) {
            output.publishRow(e.getMessage());
        }

        return rows;
    }
}
