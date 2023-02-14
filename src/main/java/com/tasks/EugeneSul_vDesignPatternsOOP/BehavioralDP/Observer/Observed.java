package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.Observer;

public interface Observed {
    void addObserver(ObserverOb observer);
    void removeObserver(ObserverOb observer);
    void notifyObservers();
}
