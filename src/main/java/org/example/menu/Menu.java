package org.example.menu;

import org.example.dialog.Dialog;
import org.example.dialog.impl.CharacterDialog;
import org.example.factory.ObjectFactory;

public class Menu {

    private static final String START_GAME_TEXT = "Type [s] to start the game or [e] to exit";
    private static final String INVALID_INPUT_TEXT = "Input must be single character";
    private static final String WRONG_COMMAND_TEXT = "Wrong command";

    private static final char START_COMMAND = 's';
    private static final char EXIT_COMMAND = 'e';

    private final ObjectFactory objectFactory = new ObjectFactory();

    public void start() {
        while (true) {
            final Dialog<Character> characterDialog = new CharacterDialog(START_GAME_TEXT, INVALID_INPUT_TEXT);
            final char inputChar = characterDialog.input();

            if (isExit(inputChar)) {
                return;
            } else if (isStart(inputChar)) {
                objectFactory.getGame().start();
            } else {
                System.err.println(WRONG_COMMAND_TEXT);
            }
        }
    }

    private boolean isExit(char inputChar) {
        return inputChar == EXIT_COMMAND;
    }

    private boolean isStart(char inputChar) {
        return inputChar == START_COMMAND;
    }

}
