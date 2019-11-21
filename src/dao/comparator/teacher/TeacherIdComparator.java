package dao.comparator.teacher;

import beans.Teacher;

import java.util.Comparator;

public class TeacherIdComparator implements Comparator<Teacher> {
    @Override
    public int compare(Teacher teacher1,Teacher teacher2){
        return teacher1.getId() - teacher2.getId();
    }
}
