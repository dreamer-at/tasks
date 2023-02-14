package com.tasks.EugeneSul_vDesignPatternsOOP.CreationalDP.FactoryMethod;

class CppDeveloperFactory implements DeveloperFactory {

    @Override
    public Developer createDeveloper() {
        return new CppDeveloper();
    }
}
