package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.Visitor;

public class JuniorDeveloperVr implements DeveloperVr{
    @Override
    public void create(ProjectClass projectClass) {
        System.out.println("Writing wrong class...");
    }

    @Override
    public void create(DatabaseVr database) {
        System.out.println("Drop database...");
    }

    @Override
    public void create(TestVr test) {
        System.out.println("Creating not reliable test...");
    }
}
