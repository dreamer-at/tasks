package com.tasks.EugeneSul_vDesignPatternsOOP.CreationalDP.AbsctractFactory;

import com.tasks.EugeneSul_vDesignPatternsOOP.CreationalDP.AbsctractFactory.banking.AbstractBankingTeamFactory;

public class SuperBankSystemProject {

    public static void main(String[] args) {
        AbstractProjectTeamFactory projectTeamFactory = new AbstractBankingTeamFactory();
        AbstractDeveloper developer = projectTeamFactory.getDeveloper();
        AbstractTester tester = projectTeamFactory.getTester();
        AbstractProjectManager projectManager = projectTeamFactory.getProjectManager();

        System.out.println("Creating bank system...");
        developer.writeCode();
        tester.testCode();
        projectManager.manageProject();
    }
}
