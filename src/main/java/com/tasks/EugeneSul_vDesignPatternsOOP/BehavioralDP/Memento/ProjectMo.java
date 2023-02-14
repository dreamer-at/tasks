package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.Memento;

import java.util.Date;

public class ProjectMo {
    private String version;
    private Date date;

    public void sendVersionAndDate(String version) {
        this.version = version;
        this.date = new Date();
    }

    public SaveMo save() {
        return new  SaveMo(version);
    }

    public void load(SaveMo save) {
        version = save.getVersion();
        date = save.getDate();
    }

    @Override
    public String toString() {
        return "Project:\n " +
                "\nVersion: " + version +
                "\nDate: " + date + "\n";
    }
}
