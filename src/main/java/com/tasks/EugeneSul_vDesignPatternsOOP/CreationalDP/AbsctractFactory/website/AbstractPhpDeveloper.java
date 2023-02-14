package com.tasks.EugeneSul_vDesignPatternsOOP.CreationalDP.AbsctractFactory.website;

import com.tasks.EugeneSul_vDesignPatternsOOP.CreationalDP.AbsctractFactory.AbstractDeveloper;

public class AbstractPhpDeveloper implements AbstractDeveloper {
    @Override
    public void writeCode() {
        System.out.println("PhpDeveloper writes php code...");
    }
}
