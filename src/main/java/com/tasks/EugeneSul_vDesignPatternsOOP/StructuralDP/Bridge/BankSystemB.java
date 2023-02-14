package com.tasks.EugeneSul_vDesignPatternsOOP.StructuralDP.Bridge;

public class BankSystemB extends ProgramB{
    protected BankSystemB(DeveloperB developer) {
        super(developer);
    }

    @Override
    public void developProgram() {
        System.out.println("Bank system development in progress...");
        developer.writeCode();
    }
}
