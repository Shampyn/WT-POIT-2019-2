package controller.commands;

import beans.Faculty;
import beans.Student;
import controller.ICommand;
import service.FacultyService;
import service.ServiceFactory;
import service.StudentService;

import java.util.Scanner;

public class FacultyCreateCommand implements ICommand
{
    @Override
    public boolean execute(String request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        FacultyService facultyService = serviceFactory.getFacultyService();
        if(ServiceFactory.getInstance().getTeacherService().GetLoggedInTeacher() != null) {
            if (ServiceFactory.getInstance().getStudentService().GetLoggedInStudent() != null) {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Enter faculty name:");
                    String name = scanner.nextLine();
                    int id = facultyService.GetMaxID() + 1;
                     Faculty faculty = new Faculty(id, name,ServiceFactory.getInstance().getTeacherService().GetLoggedInTeacher(),ServiceFactory.getInstance().getStudentService().GetLoggedInStudent());
                      facultyService.AddFaculty(faculty);
                    System.out.println("Success!");
                } catch (Exception e) {
                    System.out.println("Failed");
                }
            } else {
                System.out.println("Choose student first!");
            }
        }else {
            System.out.println("Choose teacher first!");
        }
        return true;
    }
}
