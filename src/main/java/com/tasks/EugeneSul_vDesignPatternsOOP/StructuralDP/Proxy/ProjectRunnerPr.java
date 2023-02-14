package com.tasks.EugeneSul_vDesignPatternsOOP.StructuralDP.Proxy;

public class ProjectRunnerPr {
    public static void main(String[] args) {
        ProjectPr project = new ProxyProject("https://www.github.com/og/realproj");
        project.run();
    }
}
