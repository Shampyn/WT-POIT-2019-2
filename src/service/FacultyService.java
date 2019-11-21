package service;

import beans.Faculty;

import java.util.List;

public interface FacultyService {
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
