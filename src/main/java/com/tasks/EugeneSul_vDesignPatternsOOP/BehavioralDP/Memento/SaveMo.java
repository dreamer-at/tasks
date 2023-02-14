package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.Memento;

import java.util.Date;

public class SaveMo {
    private final String version;
    private final Date date;

    public SaveMo(String version) {
        this.version = version;
        this.date = new Date();
    }

    public String getVersion() {
        return version;
    }

    public Date getDate() {
        return date;
    }
}
