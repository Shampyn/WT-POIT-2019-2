package controller.commands;

import beans.Teacher;
import controller.ICommand;
import service.*;

import java.util.Scanner;

public class TeacherUpdateCommand implements ICommand {
    @Override
    public boolean execute(String request) {
        if(ServiceFactory.getInstance().getTeacherService().GetLoggedInTeacher() != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter new name:");
            String name = scanner.nextLine();
            System.out.println("Enter new surname:");
            String surname = scanner.nextLine();
            Teacher updateTeacher = new Teacher(ServiceFactory.getInstance().getTeacherService().GetLoggedInTeacher().getId(),name, surname);
            ServiceFactory.getInstance().getTeacherService().UpdateTeacher(updateTeacher);
        }
        else{
            System.out.println("Choose teacher first!");
        }
        return true;
    }
}
