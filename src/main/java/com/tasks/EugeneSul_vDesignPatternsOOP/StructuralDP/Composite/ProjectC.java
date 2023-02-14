package com.tasks.EugeneSul_vDesignPatternsOOP.StructuralDP.Composite;

public class ProjectC {
    public static void main(String[] args) {
        TeamC team = new TeamC();

        DeveloperC firstJavaDeveloper = new JavaDeveloperC();
        DeveloperC secondJavaDeveloper = new JavaDeveloperC();
        DeveloperC cppDeveloper = new CppDeveloperC();

        team.addDeveloper(firstJavaDeveloper);
        team.addDeveloper(secondJavaDeveloper);
        team.addDeveloper(cppDeveloper);

        team.createProject();
    }
}
