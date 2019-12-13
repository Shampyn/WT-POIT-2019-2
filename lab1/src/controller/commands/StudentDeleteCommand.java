package controller.commands;

import controller.ICommand;
import service.ServiceFactory;

public class StudentDeleteCommand implements ICommand {
    @Override
    public boolean execute(String request) {
        if(ServiceFactory.getInstance().getStudentService().GetLoggedInStudent() != null){
            ServiceFactory.getInstance().getStudentService().DeleteStudent(ServiceFactory.getInstance().getStudentService().GetLoggedInStudent());
            System.out.println("Successfully removed!");
        }
        else{
            System.out.println("Choose student first!");
        }
        return true;
    }
}
