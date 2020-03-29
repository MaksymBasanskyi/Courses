package com.company.HttpCodes.Dao;

import com.company.DataManagement.Component.DataManager;
import com.company.HttpCodes.Model.Enum.ErrorCode;

public class ErrorCodeRepository {
    private DataManager dataManager;

    public ErrorCodeRepository(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public ErrorCode take() {
        return ErrorCode.getByCode(dataManager.getInt());
    }
}
