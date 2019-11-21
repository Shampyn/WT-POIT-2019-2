package dao.comparator.faculty;

import beans.Faculty;

import java.util.Comparator;

public class FacultyIdComparator implements Comparator<Faculty> {
    @Override
    public int compare(Faculty faculty1,Faculty faculty2){
        return faculty1.getId() - faculty2.getId();
    }
}
