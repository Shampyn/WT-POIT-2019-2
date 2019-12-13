package dao.comparator.teacher;

import beans.Teacher;

import java.util.Comparator;

public class TeacherNameComparator implements Comparator<Teacher> {
    @Override
    public int compare(Teacher teacher1,Teacher teacher2){
        return teacher1.getName().compareTo(teacher2.getName());
    }
}
