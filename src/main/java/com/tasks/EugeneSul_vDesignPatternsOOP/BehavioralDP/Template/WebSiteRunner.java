package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.Template;

public class WebSiteRunner {
    public static void main(String[] args) {
        WebSiteTemplate welcomePage = new WelcomePage();
        WebSiteTemplate newsPage = new NewsPage();

        welcomePage.showPage();
        System.out.println("\n========================================================================\n");
        newsPage.showPage();
    }
}
