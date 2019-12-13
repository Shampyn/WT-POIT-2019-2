package dao;

import beans.Student;

import java.util.List;

public interface StudentDAO {
    void AddStudent(Student student);
    void DeleteStudent(Student student);
    void UpdateStudent(Student student);
    void ChooseStudent(Student student);
    int GetMaxID();
    void SortById();
    void SortByStudentName();
    Student SearchById(int id);
    Student SearchByStudentName(String name);
    List<Student> ReadStudent();
    Student GetLoggedInStudent();
}
