package advisor.ui;

import advisor.controller.ConsoleController;

import java.util.Scanner;

public class ConsoleUI {

    private static final String userInputStr = "> ";
    private static final String commandExit = "exit";

    private ConsoleController consoleController;

    public ConsoleUI() {
        consoleController = new ConsoleController();
    }

    public void go() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(userInputStr);
            String line = scanner.nextLine();
            if (commandExit.equals(line)) {
                break;
            } else {
                System.out.println();
            }
        }
    }
}
