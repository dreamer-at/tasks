package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.Visitor;

public class ProjectRunnerVr {
    public static void main(String[] args) {
        ProjectVr project = new ProjectVr();
        JuniorDeveloperVr juniorDeveloper = new JuniorDeveloperVr();
        SeniorDeveloperVr seniorDeveloper = new SeniorDeveloperVr();

        System.out.println("Junior in Action...");
        project.beWritten(juniorDeveloper);
        System.out.println("\n====================================================================================\n");
        System.out.println("Senior in Action...");
        project.beWritten(seniorDeveloper);


    }
}
