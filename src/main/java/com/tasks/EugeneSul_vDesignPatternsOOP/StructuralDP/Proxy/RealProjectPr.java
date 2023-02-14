package com.tasks.EugeneSul_vDesignPatternsOOP.StructuralDP.Proxy;

public class RealProjectPr implements ProjectPr{
    private final String url;

    public RealProjectPr(String url) {
        this.url = url;
        load();
    }

    public void load() {
        System.out.println("Loading project from url...");
    }

    @Override
    public void run() {
        System.out.println("Running project " + url + "...");
    }
}
