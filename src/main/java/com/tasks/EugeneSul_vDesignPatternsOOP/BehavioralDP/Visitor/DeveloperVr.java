package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.Visitor;

public interface DeveloperVr {
    void create(ProjectClass projectClass);
    void create(DatabaseVr database);
    void create(TestVr test);

}
