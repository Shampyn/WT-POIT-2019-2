package service.implementation;

import beans.Student;
import dao.DAOFactory;
import dao.StudentDAO;
import service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    DAOFactory daoFactory = DAOFactory.getInstance();
    StudentDAO studentDAO = daoFactory.getXMLstudentDAO();

    @Override
    public void AddStudent(Student student) {
        studentDAO.AddStudent(student);
    }

    @Override
    public void DeleteStudent(int id) {
        studentDAO.DeleteStudent(id);
    }

    @Override
    public void UpdateStudent(Student student) {
        studentDAO.UpdateStudent(student);
    }

    @Override
    public int GetMaxID() {
        return studentDAO.GetMaxID();
    }

    @Override
    public void SortById() {
        studentDAO.SortById();;
    }

    @Override
    public void SortByStudentName() {
        studentDAO.SortByStudentName();
    }

    @Override
    public Student SearchById(int id) {
        return studentDAO.SearchById(id);
    }

    @Override
    public Student SearchByStudentName(String name) {
        return studentDAO.SearchByStudentName(name);
    }

    @Override
    public List<Student> ReadFaculty() {
        return studentDAO.ReadStudent();
    }
}
