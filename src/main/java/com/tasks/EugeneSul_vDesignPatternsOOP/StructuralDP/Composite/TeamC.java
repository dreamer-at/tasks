package com.tasks.EugeneSul_vDesignPatternsOOP.StructuralDP.Composite;

import java.util.ArrayList;
import java.util.List;

public class TeamC {
    private List<DeveloperC> developers = new ArrayList<>();

    public void addDeveloper(DeveloperC developer) {
        developers.add(developer);
    }

    public void removeDeveloper(DeveloperC developer) {
        developers.remove(developer);
    }

    public void createProject() {
        System.out.println("Team creates project...\n");
        for(DeveloperC developer : developers) {
            developer.writeCode();
        }
    }
}
