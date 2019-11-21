package dao;

import beans.Student;

import java.util.List;

public interface StudentDAO {
    void AddStudent(Student student);
    void DeleteStudent(int id);
    void UpdateStudent(Student student);
    int GetMaxID();
    void SortById();
    void SortByStudentName();
    Student SearchById(int id);
    Student SearchByStudentName(String name);
    List<Student> ReadStudent();
}
