package com.tasks.EugeneSul_vDesignPatternsOOP.CreationalDP.Singleton;

public class ProgramRunner {
    public static void main(String[] args) {
        SingletonProgramLogger.getProgramLogger().addLogInfo("First log...");
        SingletonProgramLogger.getProgramLogger().addLogInfo("Second log...");
        SingletonProgramLogger.getProgramLogger().addLogInfo("Third log...");

        SingletonProgramLogger.getProgramLogger().showFile();
    }
}
