package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.ChainOfResponsibility;

public class EmailNotifierChR extends NotifierChR{

    public EmailNotifierChR(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("Sending email: " + message);
    }
}
