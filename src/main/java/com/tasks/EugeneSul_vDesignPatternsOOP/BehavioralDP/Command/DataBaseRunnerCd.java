package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.Command;

public class DataBaseRunnerCd {
    public static void main(String[] args) {
        DataBaseCd dataBase = new DataBaseCd();
        DeveloperCd developer = new DeveloperCd(
                new InsertCommandCd(dataBase),
                new UpdateCommandCd(dataBase),
                new SelectCommandCd(dataBase),
                new DeleteCommandCd(dataBase)
        );

        developer.insertRecord();
        developer.updateRecord();
        developer.selectRecord();
        developer.deleteRecord();
    }
}
