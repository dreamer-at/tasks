package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.State;

public class DeveloperSt {
    ActivitySt activity;

    public void setActivity(ActivitySt activity) {
        this.activity = activity;
    }

    public void changeActivity(){
        if(activity instanceof SleepingSt) {
            setActivity(new TrainingSt());
        } else if(activity instanceof TrainingSt) {
            setActivity(new CodingSt());
        } else if(activity instanceof CodingSt) {
            setActivity(new ReadingSt());
        } else if(activity instanceof ReadingSt) {
            setActivity(new SleepingSt());
        }
    }

    public void justDoIt() {
        activity.justDoIt();
    }
}
