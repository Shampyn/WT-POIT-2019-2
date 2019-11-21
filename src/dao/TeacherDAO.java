package dao;

import beans.Teacher;

import java.util.List;

public interface TeacherDAO {
    void AddTeacher(Teacher teacher);
    void DeleteTeacher(int id);
    void UpdateTeacher(Teacher teacher);
    int GetMaxID();
    void SortById();
    void SortByTeacherName();
    Teacher SearchById(int id);
    Teacher SearchByTeacherName(String name);
    List<Teacher> ReadTeacher();
}
