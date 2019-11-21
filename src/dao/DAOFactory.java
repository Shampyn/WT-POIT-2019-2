package dao;

import dao.implementation.XMLFacultyDAO;
import dao.implementation.XMLStudentDAO;
import dao.implementation.XMLTeacherDAO;

public final class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();
    private FacultyDAO XMLfacultyDAOImpl;
    private TeacherDAO XMLteacherDAOImpl;
    private StudentDAO XMLstudentDAOImpl;

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return instance;
    }

    public FacultyDAO getXMLfacultyDAO(){
        if(XMLfacultyDAOImpl == null){
           XMLfacultyDAOImpl = new XMLFacultyDAO();
        }
        return  XMLfacultyDAOImpl;
    }
    public TeacherDAO getXMLteacherDAO(){
        if(XMLfacultyDAOImpl == null){
            XMLteacherDAOImpl = new XMLTeacherDAO();
        }
        return  XMLteacherDAOImpl;
    }
    public StudentDAO getXMLstudentDAO(){
        if(XMLfacultyDAOImpl == null){
            XMLstudentDAOImpl = new XMLStudentDAO();
        }
        return  XMLstudentDAOImpl;
    }

}
