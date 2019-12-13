package controller;

import controller.commands.*;

import java.util.HashMap;
import java.util.Map;
public class CommandHelper {
    private static final CommandHelper instance = new CommandHelper();
    private Map<CommandName, ICommand> commands = new HashMap<>();

    public CommandHelper(){
        commands.put(CommandName.CREATE_TEACHER_COMMAND, new TeacherCreateCommand());
        commands.put(CommandName.CHOOSE_TEACHER_COMMAND, new TeacherChooseCommand());
        commands.put(CommandName.SHOW_TEACHER_COMMAND, new TeachersShowCommand());
        commands.put(CommandName.UPDATE_TEACHER_COMMAND, new TeacherUpdateCommand());
        commands.put(CommandName.DELETE_TEACHER_COMMAND, new TeacherDeleteCommand());
        commands.put(CommandName.SEARCHBYNAME_TEACHER_COMMAND, new TeacherSearchByNameCommand());
        commands.put(CommandName.SRTBYNAME_TEACHER_COMMAND, new TeacherSortByNameCommand());
        commands.put(CommandName.CREATE_STUDENT_COMMAND, new StudentCreateCommand());
        commands.put(CommandName.CHOOSE_STUDENT_COMMAND, new StudentChooseCommand());
        commands.put(CommandName.SHOW_STUDENT_COMMAND, new StudentsShowCommand());
        commands.put(CommandName.DELETE_STUDENT_COMMAND, new StudentDeleteCommand());
        commands.put(CommandName.CREATE_FACULTY_COMMAND, new FacultyCreateCommand());
        commands.put(CommandName.SHOW_FACULTY_COMMAND, new FacultyShowCommand());
        commands.put(CommandName.EXIT_COMMAND, new ExitCommand());
        commands.put(CommandName.NO_SUCH_COMMAND, new NoSuchCommand());
    }
    public static CommandHelper getInstance(){
        return instance;
    }

    public ICommand getCommand(String commandName){
        ICommand command;
        try{
            CommandName name = CommandName.valueOf(commandName.toUpperCase());
            if(name != null){
                command = commands.get(name);
            }
            else{
                command = commands.get(CommandName.NO_SUCH_COMMAND);
            }
        }
        catch (IllegalArgumentException | NullPointerException exception){
            command = commands.get(CommandName.NO_SUCH_COMMAND);
        }

        return command;
    }
}
