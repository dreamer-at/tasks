package com.tasks.EugeneSul_vDesignPatternsOOP.StructuralDP.Decorator;

public class JavaTeamLeadD extends DeveloperDecorator{
    public JavaTeamLeadD(DeveloperD developer) {
        super(developer);
    }

    public String sendWeekReport() {
        return "...Send week report to customer.";
    }

    @Override
    public String makeJob() {
        return super.makeJob()  + sendWeekReport();
    }
}
