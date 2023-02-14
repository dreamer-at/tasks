package com.tasks.EugeneSul_vDesignPatternsOOP.StructuralDP.Bridge;

public class ProgramCreator {
    public static void main(String[] args) {
        ProgramB[] programs = {
                new BankSystemB(new CppDeveloperB()),
                new StockExchange(new JavaDeveloperB())
        };

        for(ProgramB program : programs) {
            program.developProgram();
        }
    }
}
