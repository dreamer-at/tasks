package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.Interpreter;

public class InterpreterRunnerIr {
    public static void main(String[] args) {
        ExpressionIr isJava = getJavaExpression();
        ExpressionIr isJavaEEDeveloper = getJavaEEExpression();

        System.out.println("Does developer knows Java core?" + isJava.interpret("Java core"));
        System.out.println("Does developer knows JavaEE?" + isJavaEEDeveloper.interpret("Java Spring"));

    }

    public static ExpressionIr getJavaExpression() {
        ExpressionIr java = new TerminalExpresion("Java");
        ExpressionIr javaCore = new TerminalExpresion("Java core");

        return new OrExpression(java, javaCore);
    }

    public static ExpressionIr getJavaEEExpression() {
        ExpressionIr java = new TerminalExpresion("Java");
        ExpressionIr spring = new TerminalExpresion("Spring");

        return new AndExpression(java, spring);
    }
}
