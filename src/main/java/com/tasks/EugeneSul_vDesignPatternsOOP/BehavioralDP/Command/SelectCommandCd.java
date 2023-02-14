package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.Command;

public class SelectCommandCd implements CommandCd{
    DataBaseCd dataBaseCd;

    public SelectCommandCd(DataBaseCd dataBaseCd) {
        this.dataBaseCd = dataBaseCd;
    }

    @Override
    public void execute() {
        dataBaseCd.select();
    }
}
