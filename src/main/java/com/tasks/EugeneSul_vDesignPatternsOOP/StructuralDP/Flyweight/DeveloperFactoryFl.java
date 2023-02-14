package com.tasks.EugeneSul_vDesignPatternsOOP.StructuralDP.Flyweight;

import java.util.HashMap;
import java.util.Map;

public class DeveloperFactoryFl {
    private static final Map<String, DeveloperFl> developers = new HashMap<>();

    public DeveloperFl getDeveloperBySpeciality(String specialty) {
        DeveloperFl developer = developers.get(specialty);

        /*if(developer == null) {
            switch (specialty) {
                case "Java" -> {
                    System.out.println("Hiring java developer...");
                    developer = new JavaDeveloperFl();
                }
                case "C++" -> {
                    System.out.println("Hiring c++ developer...");
                    developer = new CppDeveloper();
                }
            }
            developers.put(specialty, developer);
        }*/
        return developer;
    }
}
