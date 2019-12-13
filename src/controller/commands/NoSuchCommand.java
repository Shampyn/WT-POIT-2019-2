package controller.commands;

import controller.ICommand;

public class NoSuchCommand implements ICommand {
    @Override
    public boolean execute(String request) {
        System.out.println("No such command! Check out what did you type.");
        return true;
    }
}
