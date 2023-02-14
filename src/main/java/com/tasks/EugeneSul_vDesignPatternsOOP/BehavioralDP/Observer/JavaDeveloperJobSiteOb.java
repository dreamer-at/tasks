package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.Observer;

import java.util.ArrayList;
import java.util.List;

public class JavaDeveloperJobSiteOb implements Observed{
    List<String> vacancies = new ArrayList<>();
    List<ObserverOb> subscribers = new ArrayList<>();

    public void addVacancy(String vacancy) {
        this.vacancies.add(vacancy);
        notifyObservers();
    }

    public void removeVacancy(String vacancy) {
        this.vacancies.remove(vacancy);
        notifyObservers();
    }

    @Override
    public void addObserver(ObserverOb observer) {
        this.subscribers.add(observer);
    }

    @Override
    public void removeObserver(ObserverOb observer) {
        this.subscribers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(ObserverOb observer : subscribers) {
            observer.handleEvent(this.vacancies);
        }
    }
}
