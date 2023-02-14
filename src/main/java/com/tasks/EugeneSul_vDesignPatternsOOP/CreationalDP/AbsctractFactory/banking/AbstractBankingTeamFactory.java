package com.tasks.EugeneSul_vDesignPatternsOOP.CreationalDP.AbsctractFactory.banking;

import com.tasks.EugeneSul_vDesignPatternsOOP.CreationalDP.AbsctractFactory.AbstractDeveloper;
import com.tasks.EugeneSul_vDesignPatternsOOP.CreationalDP.AbsctractFactory.AbstractProjectManager;
import com.tasks.EugeneSul_vDesignPatternsOOP.CreationalDP.AbsctractFactory.AbstractProjectTeamFactory;
import com.tasks.EugeneSul_vDesignPatternsOOP.CreationalDP.AbsctractFactory.AbstractTester;

public class AbstractBankingTeamFactory implements AbstractProjectTeamFactory {


    @Override
    public AbstractDeveloper getDeveloper() {
        return new AbstractJavaDeveloper();
    }

    @Override
    public AbstractTester getTester() {
        return new AbstractQATester();
    }

    @Override
    public AbstractProjectManager getProjectManager() {
        return new AbstractBankingPM();
    }
}
