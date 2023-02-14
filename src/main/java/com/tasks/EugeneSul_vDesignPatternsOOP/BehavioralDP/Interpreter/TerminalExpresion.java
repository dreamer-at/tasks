package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.Interpreter;

public class TerminalExpresion implements ExpressionIr {
    private String data;

    public TerminalExpresion(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        if (context.contains(data)) {
            return true;
        }
        return false;
    }
}
