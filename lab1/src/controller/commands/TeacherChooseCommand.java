package controller.commands;

import beans.Teacher;
import controller.ICommand;
import service.ServiceFactory;

import java.util.List;
import java.util.Scanner;

public class TeacherChooseCommand implements ICommand {
    @Override
    public boolean execute(String request) {
        List<Teacher> ListOfTeachers = ServiceFactory.getInstance().getTeacherService().ReadTeacher();
        int count = ListOfTeachers.size();

        if(count != 0) {
            for (int i = 0; i < count; i++) {
                System.out.println("---------------------------------------------------");
                System.out.println("Account #" + i);
                System.out.println(ListOfTeachers.get(i).toString());
                System.out.println("---------------------------------------------------");
            }
            System.out.println("Choose an account:");
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            try{
                ServiceFactory.getInstance().getTeacherService().ChooseTeacher(ListOfTeachers.get(number));
                System.out.println("You are successfully logged in!");
            }
            catch (Exception e){
                System.out.println("No such account!");
            }
        }else{
            System.out.println("Add/Load at least 1 teacher!");
        }
        return true;

    }
}
