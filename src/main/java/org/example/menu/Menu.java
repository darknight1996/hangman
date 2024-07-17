package org.example.menu;

import org.example.constants.Constants;
import org.example.dialog.Dialog;
import org.example.dialog.impl.CharacterDialog;
import org.example.factory.ObjectFactory;
import org.example.content.MenuContent;

public class Menu {

    private final MenuContent menuContent;

    public Menu(MenuContent menuContent) {
        this.menuContent = menuContent;
    }

    public void start() {
        while (true) {
            final Dialog<Character> characterDialog = new CharacterDialog(menuContent.getStartMenu(), menuContent.getWrongCommand());
            final char inputChar = characterDialog.input();

            if (isExit(inputChar)) {
                return;
            } else if (isStart(inputChar)) {
                ObjectFactory.getInstance().getGame().start();
            } else {
                System.out.println(menuContent.getWrongCommand());
            }
        }
    }

    private boolean isExit(char inputChar) {
        return inputChar == Constants.EXIT_COMMAND;
    }

    private boolean isStart(char inputChar) {
        return inputChar == Constants.START_COMMAND;
    }

}
