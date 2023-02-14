package com.tasks.EugeneSul_vDesignPatternsOOP.CreationalDP.AbsctractFactory.banking;

import com.tasks.EugeneSul_vDesignPatternsOOP.CreationalDP.AbsctractFactory.AbstractDeveloper;

public class AbstractJavaDeveloper implements AbstractDeveloper {
    @Override
    public void writeCode() {
        System.out.println("Java Developer writes Java code...");
    }
}
