package com.tasks.EugeneSul_vDesignPatternsOOP.CreationalDP.AbsctractFactory;

import com.tasks.EugeneSul_vDesignPatternsOOP.CreationalDP.AbsctractFactory.website.AbstractWebsiteTeamFactory;

public class AuctionSiteProject {
    public static void main(String[] args) {
        AbstractProjectTeamFactory teamFactory = new AbstractWebsiteTeamFactory();
        AbstractDeveloper developer = teamFactory.getDeveloper();
        AbstractTester tester = teamFactory.getTester();
        AbstractProjectManager projectManager = teamFactory.getProjectManager();

        System.out.println("Creating auction website... ");
        developer.writeCode();
        tester.testCode();
        projectManager.manageProject();
    }
}
