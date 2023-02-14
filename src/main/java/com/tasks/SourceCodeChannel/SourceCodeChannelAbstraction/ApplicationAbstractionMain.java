package com.tasks.SourceCodeChannel.SourceCodeChannelAbstraction;


public class ApplicationAbstractionMain {

    public static void main(String[] args) {

        ApplicationAbstraction app = new ApplicationAbstraction();
        app.addCore();
        app.addGUI();
        app.start();

    }
}
