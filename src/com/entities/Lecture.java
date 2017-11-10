package com.entities;

import java.util.ArrayList;

public class Lecture {

    private Discipline discipline;
    private Professor professor;
    private ArrayList<Group> groups;

    public Lecture(Discipline discipline, Professor professor, ArrayList<Group> groups) {
        this.discipline = discipline;
        this.professor = professor;
        this.groups = groups;
        professor.setLecture(this);
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    @Override
    public String toString() {
        String groupNames = "";
        for (Group group: groups) {
            groupNames += group.getGroupName() + " ";
        }
        return "Discipline " + discipline.toString() + "; professor " + professor.getName()+ "; groups in lecture: " + groupNames;
    }

}
