import com.entities.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Group> groups = new ArrayList<>();
        groups.add(new Group("IO-41"));
        groups.add(new Group("IO-42"));
        groups.add(new Group("IO-43"));
        groups.add(new Group("IO-44"));
        Qualities qualities = new Qualities();
        Student student = new Student("Mary", 1, qualities, false);
        groups.get(2).addStudent(student);

        Professor professor = Professor.generate();
        Professor professor1 = new Professor("Boyko");

        for (Group group: groups) {
            group.fillGroupToStudents();
            group.captainElections();
        }
        Lecture lecture = new Lecture(Discipline.HISTORY, professor, groups);
        System.out.println(lecture);
        professor.checkStudents();
        System.out.println(professor);
        System.out.println(groups.get(2).getGroupName());
        groups.get(1).fillGroupToStudents();
        groups.get(0).getStudents().get(2).initiateElections();

    }
}
