package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.Strategy;

public class DeveloperRunner {
    public static void main(String[] args) {
        DeveloperSg developer = new DeveloperSg();

        developer.setActivity(new SleepingSg());
        developer.executeActivity();

        developer.setActivity(new TrainingSg());
        developer.executeActivity();

        developer.setActivity(new CodingSg());
        developer.executeActivity();

        developer.setActivity(new ReadingSg());
        developer.executeActivity();

        developer.setActivity(new SleepingSg());
        developer.executeActivity();
    }
}
