package controller.commands;

import beans.Faculty;
import controller.ICommand;
import service.ServiceFactory;

import java.util.List;

public class FacultyShowCommand implements ICommand {
    @Override
    public boolean execute(String request) {
        List<Faculty> faculties = ServiceFactory.getInstance().getFacultyService().ReadFaculty();
        boolean nofacylty = true;
        for(Faculty faculty: faculties ){

                System.out.println("---------------------------------------------------");
                System.out.println(faculty.toString());
                System.out.println("---------------------------------------------------");
                nofacylty = false;

        }
        if(nofacylty){
            System.out.println("Add faculty first!");
        }
        return true;
    }
}
