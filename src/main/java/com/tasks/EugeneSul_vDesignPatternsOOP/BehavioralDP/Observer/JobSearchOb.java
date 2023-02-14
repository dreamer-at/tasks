package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.Observer;

public class JobSearchOb {
    public static void main(String[] args) {
        JavaDeveloperJobSiteOb jobSite = new JavaDeveloperJobSiteOb();

        jobSite.addVacancy("First Java position");
        jobSite.addVacancy("Second Java position");

        ObserverOb firstSubscriber = new Subscriber("Askhat Talasbayev");
        ObserverOb secondSubscriber = new Subscriber("Askold Sec");

        jobSite.addObserver(firstSubscriber);
        jobSite.addObserver(secondSubscriber);

        jobSite.addVacancy("Third Java Position");

        jobSite.removeVacancy("First Java Position");
    }
}
