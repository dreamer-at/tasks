package com.tasks.EugeneSul_vDesignPatternsOOP.StructuralDP.Flyweight;

import java.util.ArrayList;
import java.util.List;

public class ProjectRunnerFl {
    public static void main(String[] args) {
        DeveloperFactoryFl developerFactory = new DeveloperFactoryFl();

        List<DeveloperFl> developers = new ArrayList<>();

        developers.add(developerFactory.getDeveloperBySpeciality("Java"));
        developers.add(developerFactory.getDeveloperBySpeciality("Java"));
        developers.add(developerFactory.getDeveloperBySpeciality("Java"));
        developers.add(developerFactory.getDeveloperBySpeciality("C++"));
        developers.add(developerFactory.getDeveloperBySpeciality("C++"));
        developers.add(developerFactory.getDeveloperBySpeciality("C++"));

        for(DeveloperFl developer : developers) {
            developer.writeCode();
        }
    }
}
