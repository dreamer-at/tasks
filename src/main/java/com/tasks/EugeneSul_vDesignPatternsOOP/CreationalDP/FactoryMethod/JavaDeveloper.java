package com.tasks.EugeneSul_vDesignPatternsOOP.CreationalDP.FactoryMethod;

class JavaDeveloper implements Developer {

    private void writeJavaCode() {
        System.out.println("Java developer writes Java Code...");
    }

    @Override
    public void writeCode() {
        writeJavaCode();
    }
}
