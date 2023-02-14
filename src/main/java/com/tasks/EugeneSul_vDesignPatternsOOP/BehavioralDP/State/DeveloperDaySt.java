package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.State;

public class DeveloperDaySt {
    public static void main(String[] args) {
        ActivitySt activity = new SleepingSt();
        DeveloperSt developer = new DeveloperSt();

        developer.setActivity(activity);

        for(int i = 0; i < 10; i++) {
            developer.justDoIt();
            developer.changeActivity();
        }
    }
}
