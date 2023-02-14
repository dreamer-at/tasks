package com.tasks.EugeneSul_vDesignPatternsOOP.StructuralDP.Facade;

public class WorkflowFc {
    DeveloperFc developer = new DeveloperFc();
    JobFc job = new JobFc();
    BugTrackerFc bugTracker = new BugTrackerFc();

    public void solveProblems() {
        job.doJob();
        bugTracker.startSprint();
        developer.doJobBeforeDeadLine(bugTracker);
    }

}
