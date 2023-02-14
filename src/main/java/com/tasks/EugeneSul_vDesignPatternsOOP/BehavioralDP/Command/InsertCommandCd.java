package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.Command;

public class InsertCommandCd implements CommandCd{
    DataBaseCd dataBaseCd;

    public InsertCommandCd(DataBaseCd dataBaseCd) {
        this.dataBaseCd = dataBaseCd;
    }

    @Override
    public void execute() {
        dataBaseCd.insert();
    }
}
