package com.company.Strings.Component;

import com.company.DataManagement.Component.OutputInterface;
import com.company.Lib.Component.TaskInterface;
import com.company.Lib.Dao.RepositoryInterface;

public class StringTask implements TaskInterface {
    private OutputInterface output;
    private RepositoryInterface<String> stringRepository;

    public StringTask(OutputInterface output, RepositoryInterface<String> stringRepository) {
        this.output = output;
        this.stringRepository = stringRepository;
    }

    @Override
    public void run() {
        output.publishRow("first string");
        String needle = stringRepository.take();
        output.publishRow("second string");
        String haystack = stringRepository.take();

        output.publishRow(String.format(
                "%s is%s substring of %s",
                needle,
                haystack.contains(needle) ? "" : " not",
                haystack
        ));
    }
}
