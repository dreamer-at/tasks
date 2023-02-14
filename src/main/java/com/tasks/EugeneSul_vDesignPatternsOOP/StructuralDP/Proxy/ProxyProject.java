package com.tasks.EugeneSul_vDesignPatternsOOP.StructuralDP.Proxy;

public class ProxyProject implements ProjectPr{
    private final String url;
    private RealProjectPr realProject;

    public ProxyProject(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        if (realProject == null) {
            realProject = new RealProjectPr(url);
        }
        realProject.run();
    }
}
