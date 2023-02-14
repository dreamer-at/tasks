package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.Visitor;

public class SeniorDeveloperVr implements DeveloperVr{
    @Override
    public void create(ProjectClass projectClass) {
        System.out.println("Rewriting class after junior...");
    }

    @Override
    public void create(DatabaseVr database) {
        System.out.println("Fixing database...");
    }

    @Override
    public void create(TestVr test) {
        System.out.println("Creating reliable test...");
    }
}
