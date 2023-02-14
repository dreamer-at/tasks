package com.tasks.EugeneSul_vDesignPatternsOOP.StructuralDP.Decorator;

public class TaskD {
    public static void main(String[] args) {
        DeveloperD developer = new JavaTeamLeadD(new SeniorJavaDeveloperD(new JavaDeveloperD()));

        System.out.println("\n");
        System.out.println(developer.makeJob());
    }
}
