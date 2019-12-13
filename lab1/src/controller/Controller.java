package controller;

import java.util.Scanner;
import view.*;
public class Controller {

    public Controller(){

    }

    public void execute(){
        Scanner CommandScanner = new Scanner(System.in);
        CommandHelper helper = CommandHelper.getInstance();
        boolean ShowCommands = true;
        do{
            ViewFactory.getInstance().getConsoleView().showAvailableCommands();
            System.out.println("Enter command:");
            String CommandToExecute = CommandScanner.nextLine();
            ICommand command = helper.getCommand(CommandToExecute);
            ShowCommands = command.execute(CommandToExecute);
        }while(ShowCommands);
    }
}
