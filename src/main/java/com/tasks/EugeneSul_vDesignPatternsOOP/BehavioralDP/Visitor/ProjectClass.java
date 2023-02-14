package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.Visitor;

public class ProjectClass implements ProjectElement{
    @Override
    public void beWritten(DeveloperVr developer) {
        developer.create(this);
    }
}
