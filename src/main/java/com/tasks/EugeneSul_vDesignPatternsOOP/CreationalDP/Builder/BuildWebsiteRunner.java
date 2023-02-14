package com.tasks.EugeneSul_vDesignPatternsOOP.CreationalDP.Builder;

public class BuildWebsiteRunner {
    public static void main(String[] args) {
        DirectorB director = new DirectorB();

        director.setBuilder(new EnterpriseWebSiteBuilder());
        Website website = director.buildWebsite();

        System.out.println(website);
    }
}
