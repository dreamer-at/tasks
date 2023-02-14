package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.Iterator.Iterator;

public class JavaDeveloperIt implements CollectionIt{
    private String name;
    private String[] skills;

    public JavaDeveloperIt(String name, String[] skills) {
        this.name = name;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    @Override
    public IteratorIt getIterator() {
        return new SkillIterator();
    }

    private class SkillIterator implements IteratorIt{
        int index;

        @Override
        public boolean hasNext() {
            return index < skills.length;
        }

        @Override
        public Object next() {
            return skills[index++];
        }
    }
}
