package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.Strategy;

public class DeveloperSg {
    ActivitySg activity;

    public void setActivity(ActivitySg activity) {
        this.activity = activity;
    }

    public void executeActivity(){
        activity.justDoIt();
    }
}
