package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.Command;

public class DeleteCommandCd implements CommandCd{
    DataBaseCd dataBaseCd;

    public DeleteCommandCd(DataBaseCd dataBaseCd) {
        this.dataBaseCd = dataBaseCd;
    }

    @Override
    public void execute() {
        dataBaseCd.delete();
    }
}
