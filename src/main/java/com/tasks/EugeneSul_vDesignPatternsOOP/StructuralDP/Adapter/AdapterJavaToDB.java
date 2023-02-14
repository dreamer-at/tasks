package com.tasks.EugeneSul_vDesignPatternsOOP.StructuralDP.Adapter;

public class AdapterJavaToDB extends JavaApplication implements DatabaseAdapter{

    @Override
    public void insert() {
        saveObject();
    }

    @Override
    public void update() {
        updateObject();
    }

    @Override
    public void select() {
        loadObject();
    }

    @Override
    public void remove() {
        deleteObject();
    }
}
