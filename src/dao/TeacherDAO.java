package dao;

import beans.Teacher;

import java.util.List;

public interface TeacherDAO {
    void AddTeacher(Teacher teacher);
    void DeleteTeacher(Teacher teacher);
    void UpdateTeacher(Teacher teacher);
    void ChooseTeacher(Teacher teacher);
    Teacher GetLoggedInTeacher();
    int GetMaxID();
    void SortById();
    void SortByTeacherName();
    Teacher SearchById(int id);
    Teacher SearchByTeacherName(String name);
    List<Teacher> ReadTeacher();
}
