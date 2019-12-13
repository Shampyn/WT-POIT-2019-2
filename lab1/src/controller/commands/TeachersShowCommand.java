package controller.commands;

import controller.ICommand;
import service.ServiceFactory;

public class TeachersShowCommand implements ICommand {
    @Override
    public boolean execute(String request) {
        if(ServiceFactory.getInstance().getTeacherService().GetLoggedInTeacher() != null) {
            System.out.println("---------------------------------------------------");
            System.out.println("Account #" + ServiceFactory.getInstance().getTeacherService().ReadTeacher().indexOf(ServiceFactory.getInstance().getTeacherService().GetLoggedInTeacher()));
            System.out.println(ServiceFactory.getInstance().getTeacherService().GetLoggedInTeacher().toString());
            System.out.println("---------------------------------------------------");
        }
        else{
            System.out.println("Choose teacher first!");
        }
        return true;
    }
}
