package com.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Group {

    private String groupName;
    private ArrayList<Student> students;

    public Group(String groupName, ArrayList<Student> students) {
        this.groupName = groupName;
        this.students = students;
    }

    public Group(String groupName) {
        this(groupName, new ArrayList<>());
    }

    public Student getCaptain() {
        for (Student student: students) {
            if (student.isCaptain()) {
                return student;
            }
        }
        return null;
    }

    public void addStudent(Student novice) {
        students.add(novice);
        novice.setGroup(this);
    }

    public void captainElections() {
        HashMap<Student, Double> rating = new HashMap<>();

        for (Student student : students) {
            Qualities qualities = student.getQualities();

            double rate = qualities.getBeauty() * 0.7 + qualities.getHonest() * 1.6 + qualities.getIntelligence() + qualities.getResponsibility() * 1.4;
            rating.put(student, rate);
        }

        Map.Entry<Student, Double> newCaptain = null;

        for (Map.Entry<Student, Double> entry : rating.entrySet()) {

            if (newCaptain == null) {
                newCaptain = entry;
                continue;
            }

            if (newCaptain.getValue() < entry.getValue()) {
                newCaptain = entry;
            }
        }

        Student oldCaptain = getCaptain();
        if (oldCaptain != null) {
            oldCaptain.setCaptain(false);
        }
        newCaptain.getKey().setCaptain(true);
        System.out.println("New captain of group " + this.groupName + " is " + getCaptain().getName());
    }

    public void fillGroupToStudents() {
        students.clear();
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(20,30 + 1); i++) {
            addStudent(Student.generate());
        }
    }

    public void checkStudents() {

        int numberPresentStudent = 0;

        for (Student student: students) {

            Qualities qualities = student.getQualities();
            double probability = (qualities.getHonest() * 1.3 + qualities.getIntelligence() + qualities.getResponsibility() * 1.7) / 4 / Qualities.MAX_VALUE;

            if (probability > Math.random()) {
                numberPresentStudent++;
            }
        }
        System.out.println("In group " + getGroupName() + " present " + numberPresentStudent+ "/" + students.size());
    }

    public String getGroupName() {
        return groupName;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "Group " + getGroupName() + ";  Count of students: " + students.size() + ";  com.entities.Group captain is " + this.getCaptain().getName();

    }
}
