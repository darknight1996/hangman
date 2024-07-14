package org.example.game;

import org.example.render.MenuTextRenderer;

import java.util.Scanner;

public class Game {

    public void start() {
        final MenuTextRenderer menuTextRenderer = new MenuTextRenderer();
        final Scanner scanner = new Scanner(System.in);

        new MenuLoop(menuTextRenderer, scanner).start();
    }
}
