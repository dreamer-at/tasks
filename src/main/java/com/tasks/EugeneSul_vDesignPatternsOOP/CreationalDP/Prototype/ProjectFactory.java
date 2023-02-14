package com.tasks.EugeneSul_vDesignPatternsOOP.CreationalDP.Prototype;

public class ProjectFactory {
    ProjectPrototype project;

    public ProjectFactory(ProjectPrototype project) {
        this.project = project;
    }

    public void setProject(ProjectPrototype project) {
        this.project = project;
    }

    ProjectPrototype cloneProject() {
        return (ProjectPrototype) project.copy();
    }
}
