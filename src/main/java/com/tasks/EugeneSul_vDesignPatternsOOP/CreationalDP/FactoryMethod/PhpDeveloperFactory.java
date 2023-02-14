package com.tasks.EugeneSul_vDesignPatternsOOP.CreationalDP.FactoryMethod;

class PhpDeveloperFactory implements DeveloperFactory{
    @Override
    public Developer createDeveloper() {
        return new PhpDeveloper();
    }
}
