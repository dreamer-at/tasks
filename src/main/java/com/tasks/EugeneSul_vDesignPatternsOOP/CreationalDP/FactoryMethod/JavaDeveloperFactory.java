package com.tasks.EugeneSul_vDesignPatternsOOP.CreationalDP.FactoryMethod;

class JavaDeveloperFactory implements DeveloperFactory {
    @Override
    public Developer createDeveloper() {
        return new JavaDeveloper();
    }
}
