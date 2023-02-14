package com.tasks.EugeneSul_vDesignPatternsOOP.CreationalDP.AbsctractFactory;

public interface AbstractProjectTeamFactory {

    AbstractDeveloper getDeveloper();
    AbstractTester getTester();
    AbstractProjectManager getProjectManager();
}
