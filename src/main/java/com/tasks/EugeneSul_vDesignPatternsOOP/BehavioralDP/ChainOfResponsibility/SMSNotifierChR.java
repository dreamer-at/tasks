package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.ChainOfResponsibility;

public class SMSNotifierChR extends NotifierChR{

    public SMSNotifierChR(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("Sending SMS to manager: " + message);
    }
}
