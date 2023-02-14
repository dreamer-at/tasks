package com.tasks.EugeneSul_vDesignPatternsOOP.CreationalDP.Prototype;

public class ProjectPrototype implements CloneablePrototype{
    private int id;
    private String projectName;
    private String sourceCode;

    public ProjectPrototype(int id, String projectName, String sourceCode) {
        this.id = id;
        this.projectName = projectName;
        this.sourceCode = sourceCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    @Override
    public Object copy() {
        ProjectPrototype copy = new ProjectPrototype(id, projectName, sourceCode);
        return copy;
    }

    @Override
    public String toString() {
        return "ProjectPrototype{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", sourceCode='" + sourceCode + '\'' +
                '}';
    }
}
