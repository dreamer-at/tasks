package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.Visitor;

public class ProjectVr implements ProjectElement{
    ProjectElement[] projectElements;

    public ProjectVr() {
         this.projectElements = new ProjectElement[] {
                 new ProjectClass(),
                 new DatabaseVr(),
                 new TestVr()
         };
    }

    @Override
    public void beWritten(DeveloperVr developer) {
        for (ProjectElement p : projectElements) {
            p.beWritten(developer);
        }
    }
}
