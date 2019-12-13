package dao.comparator.student;

import beans.Student;

import java.util.Comparator;

public class StudentIdComparator implements Comparator<Student> {
    @Override
    public int compare(Student student1,Student student2){
        return student1.getId() - student2.getId();
    }
}
