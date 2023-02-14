package com.tasks.EugeneSul_vDesignPatternsOOP.StructuralDP.Decorator;

public class DeveloperDecorator implements DeveloperD{
    DeveloperD developer;

    public DeveloperDecorator(DeveloperD developer) {
        this.developer = developer;
    }

    @Override
    public String makeJob() {
        return developer.makeJob();
    }
}
