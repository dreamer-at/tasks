package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.State;

public class SleepingSt implements ActivitySt{
    @Override
    public void justDoIt() {
        System.out.println("Sleeping...");
    }
}
