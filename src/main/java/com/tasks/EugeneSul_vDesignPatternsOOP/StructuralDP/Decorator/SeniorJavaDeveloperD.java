package com.tasks.EugeneSul_vDesignPatternsOOP.StructuralDP.Decorator;

public class SeniorJavaDeveloperD extends DeveloperDecorator{

    public SeniorJavaDeveloperD(DeveloperD developer) {
        super(developer);
    }

    public String makeCodeReview() {
        return "Make code review.";
    }

    @Override
    public String makeJob() {
        return super.makeJob() + makeCodeReview();
    }
}
