package com.company.LoginValidation.Component;

import com.company.DataManagement.Component.OutputInterface;
import com.company.Lib.Component.TaskInterface;
import com.company.Lib.Dao.RepositoryInterface;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginValidationTask implements TaskInterface {
    private OutputInterface output;
    private RepositoryInterface<String> stringRepository;

    public LoginValidationTask(OutputInterface output, RepositoryInterface<String> stringRepository) {
        this.output = output;
        this.stringRepository = stringRepository;
    }

    @Override
    public void run() {
        Pattern pattern = Pattern.compile("\\w{3,15}");
        for (int i = 0; i < 5; i++) {
            output.publishRow("Enter login");
            String login = stringRepository.take();
            Matcher matcher = pattern.matcher(login);
            if (matcher.matches()) {
                output.publishRow("valid");
            } else {
                output.publishRow("invalid");
            }
        }
    }
}
