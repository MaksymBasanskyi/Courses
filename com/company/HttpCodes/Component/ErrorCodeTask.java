package com.company.HttpCodes.Component;

import com.company.DataManagement.Component.OutputInterface;
import com.company.HttpCodes.Model.Enum.ErrorCode;
import com.company.Lib.Component.TaskInterface;
import com.company.Lib.Dao.RepositoryInterface;

public class ErrorCodeTask implements TaskInterface {
    private RepositoryInterface<ErrorCode> errorCodeRepository;
    private OutputInterface output;

    public ErrorCodeTask(RepositoryInterface<ErrorCode> repository, OutputInterface output) {
        this.errorCodeRepository = repository;
        this.output = output;
    }

    public void run() {
        ErrorCode errorCode = errorCodeRepository.take();
        output.publishRow(errorCode.getErrorMessage());
    }
}
