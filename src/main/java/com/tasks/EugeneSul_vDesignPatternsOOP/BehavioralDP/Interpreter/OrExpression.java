package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.Interpreter;

public class OrExpression implements ExpressionIr{
    private ExpressionIr expression1;
    private ExpressionIr expression2;

    public OrExpression(ExpressionIr expression1, ExpressionIr expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }


    @Override
    public boolean interpret(String context) {
        return expression1.interpret(context) || expression2.interpret(context);
    }
}
