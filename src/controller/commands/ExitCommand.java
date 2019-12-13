package controller.commands;

import controller.ICommand;

public class ExitCommand implements ICommand {
    @Override
    public boolean execute(String request) {
        System.out.println("See you, Bye!");
        return false;
    }
}