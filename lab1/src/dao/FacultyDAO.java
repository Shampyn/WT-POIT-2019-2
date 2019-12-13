package dao;

import beans.Faculty;

import java.sql.Time;
import java.util.List;

public interface FacultyDAO {
    void AddFaculty(Faculty faculty);
    void DeleteFaculty(int id);
    void UpdateFaculty(Faculty faculty);
    int GetMaxID();
    void SortById();
    void SortByFacultyName();
    Faculty SearchByFacultyName(String facultyName);
    Faculty SearchById(int id);
    List<Faculty> ReadFaculty();
}
