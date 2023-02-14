package com.tasks.EugeneSul_vDesignPatternsOOP.CreationalDP.AbsctractFactory.website;

import com.tasks.EugeneSul_vDesignPatternsOOP.CreationalDP.AbsctractFactory.AbstractDeveloper;
import com.tasks.EugeneSul_vDesignPatternsOOP.CreationalDP.AbsctractFactory.AbstractProjectManager;
import com.tasks.EugeneSul_vDesignPatternsOOP.CreationalDP.AbsctractFactory.AbstractProjectTeamFactory;
import com.tasks.EugeneSul_vDesignPatternsOOP.CreationalDP.AbsctractFactory.AbstractTester;

public class AbstractWebsiteTeamFactory implements AbstractProjectTeamFactory {
    @Override
    public AbstractDeveloper getDeveloper() {
         return new AbstractPhpDeveloper();
    }

    @Override
    public AbstractTester getTester() {
        return new AbstractManualTester();
    }

    @Override
    public AbstractProjectManager getProjectManager() {
        return new AbstractWebsitePM();
    }
}
