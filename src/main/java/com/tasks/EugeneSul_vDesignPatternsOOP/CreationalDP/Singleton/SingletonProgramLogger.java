package com.tasks.EugeneSul_vDesignPatternsOOP.CreationalDP.Singleton;


public class SingletonProgramLogger {
    private static SingletonProgramLogger programLogger;
    private static String logFile = "This is log file...";

    public static synchronized SingletonProgramLogger getProgramLogger(){
        if(programLogger == null) {
            programLogger = new SingletonProgramLogger();
        }
        return programLogger;
    }

    private SingletonProgramLogger() {

    }

    public void addLogInfo(String logInfo) {
        logFile += logInfo + "\n";
    }

    public void showFile() {
        System.out.println(logFile);
    }
}
