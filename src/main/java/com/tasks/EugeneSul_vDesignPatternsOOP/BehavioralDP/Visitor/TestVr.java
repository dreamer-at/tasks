package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.Visitor;

public class TestVr implements ProjectElement {
    @Override
    public void beWritten(DeveloperVr developer) {
        developer.create(this);
    }
}
