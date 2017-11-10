package com.entities;

import java.util.concurrent.ThreadLocalRandom;

public class Student {

    private static final String[] names = {"Bob", "Sindy", "Pol", "Richard", "Gloria", "Michel", "Dennis", "Ivan", "Jenifer", "Mary"};

    private String name;
    private int course;
    private boolean captain;
    private Qualities qualities;
    private Group group;

    public Student(String name) {
        this(name, 1, Qualities.generate(), false);
    }

    public Student(String name, int course, Qualities qualities, boolean captain) {
        this.name = name;
        this.course = course;
        this.qualities = qualities;
        this.captain = captain;
    }

    public static Student generate() {
        return new Student(names[ThreadLocalRandom.current().nextInt(names.length)]);
    }

    public void initiateElections() {
        group.captainElections();
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public boolean isCaptain() {
        return captain;
    }

    public Qualities getQualities() {
        return qualities;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setCaptain(boolean captain) {
        this.captain = captain;
    }

    @Override
    public String toString() {
        return "Student`s name is " + name + ";  His course is " + course + ";  "+ qualities ;
    }
}
