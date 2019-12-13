package controller.commands;

import controller.ICommand;
import service.ServiceFactory;

public class StudentsShowCommand implements ICommand {
    @Override
    public boolean execute(String request) {

        if(ServiceFactory.getInstance().getStudentService().GetLoggedInStudent() != null) {
            System.out.println("---------------------------------------------------");
            System.out.println("Account #" + ServiceFactory.getInstance().getStudentService().ReadStudent().indexOf(ServiceFactory.getInstance().getStudentService().GetLoggedInStudent()));
            System.out.println(ServiceFactory.getInstance().getStudentService().GetLoggedInStudent().toString());
            System.out.println("---------------------------------------------------");
        }
        else{
            System.out.println("Choose student first!");
        }
        return true;
    }
}
