package controller.commands;

import beans.Teacher;
import controller.ICommand;
import service.*;

import java.util.List;


public class TeacherSortByNameCommand implements ICommand {
    @Override
    public boolean execute(String request) {
        ServiceFactory.getInstance().getTeacherService().SortByTeacherName();
        List<Teacher> ListOfTeachers = ServiceFactory.getInstance().getTeacherService().ReadTeacher();
        int count = ListOfTeachers.size();
        if(count != 0) {
            for (int i = 0; i < count; i++) {
                System.out.println("---------------------------------------------------");
                System.out.println("Account #" + i);
                System.out.println(ListOfTeachers.get(i).toString());
                System.out.println("---------------------------------------------------");
            }
        }
        System.out.println("Sorted by Name");
        return true;
    }
}
