package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.Observer;

import java.util.List;

public class Subscriber implements ObserverOb{

    String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void handleEvent(List<String> vacancies) {
        System.out.println("Dear " + name + "\nWe have some changes in vacancies:\n" + vacancies +
                "\n=====================================================================\n");
    }
}
