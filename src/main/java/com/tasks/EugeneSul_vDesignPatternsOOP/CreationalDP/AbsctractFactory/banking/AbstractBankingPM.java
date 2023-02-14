package com.tasks.EugeneSul_vDesignPatternsOOP.CreationalDP.AbsctractFactory.banking;

import com.tasks.EugeneSul_vDesignPatternsOOP.CreationalDP.AbsctractFactory.AbstractProjectManager;

public class AbstractBankingPM implements AbstractProjectManager {
    @Override
    public void manageProject() {
        System.out.println("Banking PM manages banking project...");
    }
}
