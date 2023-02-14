package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.Memento;

public class SaveProjectRunnerMo {
    public static void main(String[] args) throws InterruptedException {
        ProjectMo project = new ProjectMo();
        GitHubRepoMo gitHubRepo = new GitHubRepoMo();

        System.out.println("Creating new project. Version 1.0");
        project.sendVersionAndDate("Version 1.0");

        System.out.println(project);

        System.out.println("Saving current version to github...");
        gitHubRepo.setSave(project.save());

        System.out.println("Updating project to version 1.1");

        System.out.println("Writing poor code...");
        Thread.sleep(5000);
        project.sendVersionAndDate("Version 1.1");

        System.out.println(project);

        System.out.println("Something went wrong...");

        System.out.println("Rolling back to version 1.0");
        project.load(gitHubRepo.getSave());

        System.out.println("Project after rollback");

        System.out.println(project);
    }
}
