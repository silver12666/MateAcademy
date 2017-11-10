package com.entities;

import java.util.concurrent.ThreadLocalRandom;

public class Professor {

    private static final String[] names = {"Sikorsky", "Pavlov", "Korochkin", "Novotarsky"};

    private String name;
    private Lecture lecture;

    public Professor(String name) {
        this.name = name;
    }

    public static Professor generate() {
        return new Professor(names[ThreadLocalRandom.current().nextInt(names.length)]);
    }

    public void checkStudents() {
        if (this.lecture == null) {
            System.out.println("Professor hasn`t lecture");
            return;
        }
        for (Group group: lecture.getGroups()) {
            group.checkStudents();
        }
    }

    public String getName() {
        return name;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    @Override
    public String toString() {
        return "Professor`s name is " + name;
    }
}
