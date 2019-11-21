package service;

import service.implementation.FacultyServiceImpl;
import service.implementation.StudentServiceImpl;
import service.implementation.TeacherServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final FacultyService facultyService = new FacultyServiceImpl();
    private final StudentService studentService = new StudentServiceImpl();
    private final TeacherService teacherService = new TeacherServiceImpl();


    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return instance;
    }

    public FacultyService  getFacultyService () {
        return facultyService;
    }

    public StudentService  getStudentService () {
        return studentService;
    }

    public TeacherService   getTeacherService  () {
        return teacherService;
    }
}
