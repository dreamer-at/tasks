package com.tasks.EugeneSul_vDesignPatternsOOP.StructuralDP.Facade;

public class BugTrackerFc {
    private boolean activeSprint;

    public boolean isActiveSprint() {
        return activeSprint;
    }

    public void startSprint() {
        System.out.println("Sprint is active.");
        activeSprint = true;
    }

    public void finishSprint() {
        System.out.println("Spring is not active.");
        activeSprint = false;
    }
}
