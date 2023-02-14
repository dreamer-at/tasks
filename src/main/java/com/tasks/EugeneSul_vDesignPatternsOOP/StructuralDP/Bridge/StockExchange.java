package com.tasks.EugeneSul_vDesignPatternsOOP.StructuralDP.Bridge;

public class StockExchange extends ProgramB{
    protected StockExchange(DeveloperB developer) {
        super(developer);
    }

    @Override
    public void developProgram() {
        System.out.println("Stock exchange development in progress...");
        developer.writeCode();
    }
}
