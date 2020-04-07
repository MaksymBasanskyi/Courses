package com.company.UserName.Component;

import com.company.DataManagement.Component.OutputInterface;
import com.company.Lib.Component.TaskInterface;
import com.company.Lib.Dao.RepositoryInterface;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserNameTask implements TaskInterface {
    private OutputInterface output;
    private RepositoryInterface<String> stringRepository;

    public UserNameTask(OutputInterface output, RepositoryInterface<String> stringRepository) {
        this.output = output;
        this.stringRepository = stringRepository;
    }

    @Override
    public void run() {
        output.publishRow("enter your surname, name and patronymic separated by semicolon");
        String userInfo = stringRepository.take();
        Pattern pattern = Pattern.compile("(?<surname>.*);(?<name>.*);(?<patronymic>.*)");
        Matcher matcher = pattern.matcher(userInfo);
        if (!matcher.matches()) {
            output.publishRow("Invalid row");
        } else {
            String surname = matcher.group("surname");
            String name = matcher.group("name");
            String patronymic = matcher.group("patronymic");
            String surnameWithInitials = new StringBuilder(surname)
                    .append(" ")
                    .append(name, 0, 1)
                    .append(". ")
                    .append(patronymic, 0, 1)
                    .append(".")
                    .toString();
            String userNameInAnotherOrder = new StringBuilder(name)
                    .append(" ")
                    .append(patronymic)
                    .append(" ")
                    .append(surname)
                    .toString();
            output.publishRow(surnameWithInitials);
            output.publishRow(name);
            output.publishRow(userNameInAnotherOrder);
        }
    }
}
