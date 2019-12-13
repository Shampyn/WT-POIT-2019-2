package controller.commands;

import beans.Teacher;
import controller.ICommand;
import service.*;
import java.util.Scanner;

public class TeacherSearchByNameCommand implements ICommand {
    @Override
    public boolean execute(String request) {
        System.out.println("Enter name that you want to find:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Teacher teacher = ServiceFactory.getInstance().getTeacherService().SearchByTeacherName(name);
        if(teacher != null){
            System.out.println("---------------------------------------------------");
            System.out.println(teacher.toString());
            System.out.println("---------------------------------------------------");
        }
        else{
            System.out.println("Nothing found.");
        }
        return true;
    }
}
