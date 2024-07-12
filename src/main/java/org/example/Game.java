package org.example;

import java.util.Scanner;

public class Game {
    private static final String START = "s";
    private static final String EXIT = "e";

    public void start() {
        startMenuLoop();
    }

    private void startMenuLoop() {
        while (true) {
            System.out.println("Type [s] to start the game or [e] to exit");
            Scanner scanner = new Scanner(System.in);
            String inputStringFromConsole = scanner.nextLine();
            if (inputStringFromConsole.equals(EXIT)) {
                return;
            } else if (inputStringFromConsole.equals(START)) {
                startGameLoop();
            } else {
                System.out.println("wrong command");
            }
        }
    }

    private void startGameLoop() {
        System.out.println("game starting");
    }
}
