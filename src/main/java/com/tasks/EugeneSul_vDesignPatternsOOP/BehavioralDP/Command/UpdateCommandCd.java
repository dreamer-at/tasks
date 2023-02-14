package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.Command;

public class UpdateCommandCd implements CommandCd{
    DataBaseCd dataBaseCd;

    public UpdateCommandCd(DataBaseCd dataBaseCd) {
        this.dataBaseCd = dataBaseCd;
    }

    @Override
    public void execute() {
        dataBaseCd.update();
    }
}
