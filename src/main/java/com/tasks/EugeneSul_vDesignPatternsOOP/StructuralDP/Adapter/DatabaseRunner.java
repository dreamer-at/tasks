package com.tasks.EugeneSul_vDesignPatternsOOP.StructuralDP.Adapter;

public class DatabaseRunner {
    public static void main(String[] args) {
        DatabaseAdapter database = new AdapterJavaToDB();

        database.insert();
        database.update();
        database.select();
        database.remove();

    }
}
