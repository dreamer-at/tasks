package com.tasks.EugeneSul_vDesignPatternsOOP.CreationalDP.FactoryMethod;

class CppDeveloper implements Developer {
    private void writeCppCode() {
        System.out.println("C++ writes C++ code...");
    }

    @Override
    public void writeCode() {
        writeCppCode();
    }
}
