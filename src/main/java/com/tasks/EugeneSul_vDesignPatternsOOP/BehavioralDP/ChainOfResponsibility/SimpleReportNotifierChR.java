package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.ChainOfResponsibility;

public class SimpleReportNotifierChR extends NotifierChR{

    public SimpleReportNotifierChR(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("Notifier using simple report: " + message);
    }
}
