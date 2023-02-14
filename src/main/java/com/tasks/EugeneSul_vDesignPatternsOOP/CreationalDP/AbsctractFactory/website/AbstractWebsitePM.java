package com.tasks.EugeneSul_vDesignPatternsOOP.CreationalDP.AbsctractFactory.website;

import com.tasks.EugeneSul_vDesignPatternsOOP.CreationalDP.AbsctractFactory.AbstractProjectManager;

public class AbstractWebsitePM implements AbstractProjectManager {

    @Override
    public void manageProject() {
        System.out.println("WebsitePM manages project...");
    }
}
