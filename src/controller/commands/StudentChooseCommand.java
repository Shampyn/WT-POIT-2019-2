package controller.commands;

import beans.Student;
import controller.ICommand;
import service.ServiceFactory;

import java.util.List;
import java.util.Scanner;

public class StudentChooseCommand implements ICommand {
    @Override
    public boolean execute(String request) {
        List<Student> ListOfStudents = ServiceFactory.getInstance().getStudentService().ReadStudent();
        int count = ListOfStudents.size();

        if(count != 0) {
            for (int i = 0; i < count; i++) {
                System.out.println("---------------------------------------------------");
                System.out.println("Account #" + i);
                System.out.println(ListOfStudents.get(i).toString());
                System.out.println("---------------------------------------------------");
            }
            System.out.println("Choose an account:");
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            try{
                ServiceFactory.getInstance().getStudentService().ChooseStudent(ListOfStudents.get(number));
                System.out.println("You are successfully logged in!");
            }
            catch (Exception e){
                System.out.println("No such account!");
            }
        }else{
            System.out.println("Add/Load at least 1 student!");
        }
        return true;

    }
}
