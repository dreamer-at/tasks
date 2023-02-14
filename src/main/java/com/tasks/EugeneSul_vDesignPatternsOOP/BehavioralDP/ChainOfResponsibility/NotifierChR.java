package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.ChainOfResponsibility;

public abstract class NotifierChR {
    private int priority;
    private NotifierChR nextNotifier;

    public NotifierChR(int priority) {
        this.priority = priority;
    }

    public void setNextNotifier(NotifierChR nextNotifier) {
        this.nextNotifier = nextNotifier;
    }

    public void notifierManager(String message, int level) {
        if(level >= priority){
            write(message);
        }
        if(nextNotifier != null) {
            nextNotifier.notifierManager(message, level);
        }
    }

    public abstract void write(String message);
}
