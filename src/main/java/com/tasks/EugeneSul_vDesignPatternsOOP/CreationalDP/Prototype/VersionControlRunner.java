package com.tasks.EugeneSul_vDesignPatternsOOP.CreationalDP.Prototype;

public class VersionControlRunner {
    public static void main(String[] args) {
        ProjectPrototype master = new ProjectPrototype(
                1, "SuperProject", "SourceCode sourceCode = new SourceCode();\n");
        System.out.println(master);

        ProjectFactory factory = new ProjectFactory(master);
        ProjectPrototype masterClone = factory.cloneProject();
        System.out.println("\n=======================================\n");
        System.out.println(masterClone);
    }
}
