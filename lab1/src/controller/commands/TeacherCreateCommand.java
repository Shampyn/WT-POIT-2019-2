package controller.commands;

import beans.Teacher;
import controller.ICommand;
import service.*;

import java.util.Scanner;

public class TeacherCreateCommand implements ICommand  {
    @Override
    public boolean execute(String request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TeacherService teacherService = serviceFactory.getTeacherService();
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your name:");
            String name = scanner.nextLine();
            System.out.println("Enter your surname:");
            String surname = scanner.nextLine();
            int id = teacherService.GetMaxID() + 1;
            Teacher teacher = new Teacher(id,name, surname);
            teacherService.AddTeacher(teacher);
            System.out.println("Success!");
        } catch(Exception e){
            System.out.println("Failed");
        }
        return true;


    }
}
