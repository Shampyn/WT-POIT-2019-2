package dao.comparator.faculty;

import beans.Faculty;

import java.util.Comparator;

public class FacultyNameComparator implements Comparator<Faculty> {
    @Override
    public int compare(Faculty faculty1,Faculty faculty2){
        return faculty1.getFacultyName().compareTo(faculty2.getFacultyName());
    }
}
