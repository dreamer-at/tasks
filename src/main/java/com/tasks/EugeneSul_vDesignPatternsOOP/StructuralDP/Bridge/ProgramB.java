package com.tasks.EugeneSul_vDesignPatternsOOP.StructuralDP.Bridge;

public abstract class ProgramB {
    protected DeveloperB developer;

    protected ProgramB(DeveloperB developer) {
        this.developer = developer;
    }

    public abstract void developProgram();
}
