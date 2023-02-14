package com.tasks.EugeneSul_vDesignPatternsOOP.StructuralDP.Facade;

public class DeveloperFc {
    public void doJobBeforeDeadLine(BugTrackerFc bugTracker) {
        if(bugTracker.isActiveSprint()) {
            System.out.println("Developer is solving problem...");
        } else {
            System.out.println("Developer is reading Habrahabr...");
        }

    }
}
