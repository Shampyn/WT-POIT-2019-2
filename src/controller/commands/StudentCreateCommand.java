package controller.commands;

import beans.Student;
import beans.Teacher;
import controller.ICommand;
import service.ServiceFactory;
import service.StudentService;
import service.TeacherService;

import java.util.Scanner;

public class StudentCreateCommand implements ICommand {
    @Override
    public boolean execute(String request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        StudentService studentService = serviceFactory.getStudentService();
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your name:");
            String name = scanner.nextLine();
            System.out.println("Enter your surname:");
            String surname = scanner.nextLine();
             int id = studentService.GetMaxID() + 1;
            Student student = new Student(id,name, surname);
            studentService.AddStudent(student);
            System.out.println("Success!");
        } catch(Exception e){
            System.out.println("Failed");
        }
        return true;
    }
}
