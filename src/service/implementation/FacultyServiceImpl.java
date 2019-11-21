package service.implementation;

import beans.Faculty;
import dao.DAOFactory;
import dao.FacultyDAO;
import service.FacultyService;

import java.util.List;

public class FacultyServiceImpl implements FacultyService {
    DAOFactory daoFactory = DAOFactory.getInstance();
    FacultyDAO facultyDAO = daoFactory.getXMLfacultyDAO();

    @Override
    public void AddFaculty(Faculty faculty) {
        facultyDAO.AddFaculty(faculty);
    }

    @Override
    public void DeleteFaculty(int id) {
        facultyDAO.DeleteFaculty(id);
    }

    @Override
    public void UpdateFaculty(Faculty faculty) {
        facultyDAO.UpdateFaculty(faculty);
    }

    @Override
    public int GetMaxID() {
       return facultyDAO.GetMaxID();
    }

    @Override
    public void SortById() {
        facultyDAO.SortById();
    }

    @Override
    public void SortByFacultyName() {
        facultyDAO.SortByFacultyName();
    }

    @Override
    public Faculty SearchByFacultyName(String facultyName) {
        return facultyDAO.SearchByFacultyName(facultyName);
    }

    @Override
    public Faculty SearchById(int id) {
        return  facultyDAO.SearchById(id);
    }

    @Override
    public List<Faculty> ReadFaculty() {
        return facultyDAO.ReadFaculty();
    }
}
