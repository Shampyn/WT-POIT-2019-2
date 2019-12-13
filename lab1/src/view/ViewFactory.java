package view;

import view.impl.ConsoleView;


public class ViewFactory {
    private static final ViewFactory instance = new ViewFactory();
    private final View consoleView = new ConsoleView();

    private  ViewFactory(){

    }

    public static ViewFactory getInstance(){
        return instance;
    }

    public View getConsoleView() {
        return consoleView;
    }
}
