package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.ChainOfResponsibility;

public class BugTrackerChR {
    public static void main(String[] args) {
        NotifierChR notifierReport = new SimpleReportNotifierChR(PriorityChr.ROUTINE);
        NotifierChR notifierEmail = new EmailNotifierChR(PriorityChr.IMPORTANT);
        NotifierChR notifierSMS = new SMSNotifierChR(PriorityChr.ASAP);

        notifierReport.setNextNotifier(notifierEmail);
        notifierEmail.setNextNotifier(notifierSMS);

        notifierReport.notifierManager("Everything is OK", PriorityChr.ROUTINE);
        notifierReport.notifierManager("Something went wrong", PriorityChr.IMPORTANT);
        notifierReport.notifierManager("Houston, we've had problems here", PriorityChr.ASAP);
    }
}
