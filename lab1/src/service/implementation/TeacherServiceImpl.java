package service.implementation;

import beans.Teacher;
import dao.DAOFactory;
import dao.TeacherDAO;
import service.TeacherService;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {
    DAOFactory daoFactory = DAOFactory.getInstance();
    TeacherDAO teacherDAO = daoFactory.getXMLteacherDAO();

    @Override
    public void AddTeacher(Teacher teacher) {
        teacherDAO.AddTeacher(teacher);
    }

    @Override
    public void DeleteTeacher(Teacher teacher) {
        teacherDAO.DeleteTeacher(teacher);
    }

    @Override
    public void UpdateTeacher(Teacher teacher) {
        teacherDAO.UpdateTeacher(teacher);
    }

    @Override
    public void ChooseTeacher(Teacher teacher) {
        teacherDAO.ChooseTeacher(teacher);
    }

    @Override
    public int GetMaxID() {
        return teacherDAO.GetMaxID();
    }

    @Override
    public void SortById() {
        teacherDAO.SortById();
    }

    @Override
    public void SortByTeacherName() {
        teacherDAO.SortByTeacherName();
    }

    @Override
    public Teacher SearchById(int id) {
        return teacherDAO.SearchById(id);
    }

    @Override
    public Teacher SearchByTeacherName(String name) {
        return teacherDAO.SearchByTeacherName(name);
    }

    @Override
    public List<Teacher> ReadTeacher() {
        return teacherDAO.ReadTeacher();
    }

    @Override
    public Teacher GetLoggedInTeacher() {
        return teacherDAO.GetLoggedInTeacher();
    }


}
