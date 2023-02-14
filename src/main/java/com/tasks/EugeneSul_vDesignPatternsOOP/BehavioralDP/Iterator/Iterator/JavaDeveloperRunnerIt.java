package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.Iterator.Iterator;

public class JavaDeveloperRunnerIt {
    public static void main(String[] args) {
        String[] skills = {"Java", "Spring", "Hibernate", "Maven", "PostgreSQL"};

        JavaDeveloperIt javaDeveloper = new JavaDeveloperIt("Askhat Tt", skills);

        IteratorIt iterator = javaDeveloper.getIterator();
        System.out.println("Developer: " + javaDeveloper.getName());
        System.out.println("Skills: ");

        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString() + " ");
        }
    }
}
