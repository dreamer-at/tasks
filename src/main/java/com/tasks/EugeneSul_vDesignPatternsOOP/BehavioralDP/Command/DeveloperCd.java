package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.Command;

public class DeveloperCd {
    CommandCd insert;
    CommandCd update;
    CommandCd select;
    CommandCd delete;

    public DeveloperCd(CommandCd insert, CommandCd update, CommandCd select, CommandCd delete) {
        this.insert = insert;
        this.update = update;
        this.select = select;
        this.delete = delete;
    }

    public void insertRecord() {
        insert.execute();
    }

    public void updateRecord() {
        update.execute();
    }

    public void selectRecord() {
        select.execute();
    }

    public void deleteRecord() {
        delete.execute();
    }
}
