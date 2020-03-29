package com.company.HttpCodes.Component;

import com.company.DataManagement.Component.OutputInterface;
import com.company.HttpCodes.Dao.ErrorCodeRepository;
import com.company.HttpCodes.Model.Enum.ErrorCode;
import com.company.Lib.Component.TaskInterface;

public class ErrorCodeTask implements TaskInterface {
    private ErrorCodeRepository errorCodeRepository;
    private OutputInterface output;

    public ErrorCodeTask(ErrorCodeRepository errorCodeRepository, OutputInterface output) {
        this.errorCodeRepository = errorCodeRepository;
        this.output = output;
    }

    public void run() {
        ErrorCode errorCode = errorCodeRepository.take();
        output.publishRow(errorCode.getErrorMessage());
    }
}
