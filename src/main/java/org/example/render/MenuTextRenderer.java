package org.example.render;

import org.example.constants.Constants;

public class MenuTextRenderer {

    public void renderStartMenu() {
        System.out.println(Constants.START_GAME_TEXT);
    }

    public void renderWrongCommand() {
        System.out.println(Constants.WRONG_COMMAND_TEXT);
    }
}
