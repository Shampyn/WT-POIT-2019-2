package controller.commands;

import controller.ICommand;
import service.*;

public class TeacherDeleteCommand implements ICommand {
    @Override
    public boolean execute(String request) {
        if(ServiceFactory.getInstance().getTeacherService().GetLoggedInTeacher() != null){
            ServiceFactory.getInstance().getTeacherService().DeleteTeacher(ServiceFactory.getInstance().getTeacherService().GetLoggedInTeacher());
            System.out.println("Successfully removed!");
        }
        else{
            System.out.println("Choose teacher first!");
        }
        return true;
    }
}
