package org.example.game;

import org.example.constants.Constants;
import org.example.model.HiddenWord;
import org.example.render.GameTextRenderer;
import org.example.render.HangmanRenderer;
import org.example.render.MenuTextRenderer;
import org.example.repository.impl.WordsRepositoryInFile;
import org.example.service.WordService;
import org.example.service.impl.WordServiceDefaultImpl;
import org.example.validator.Validator;

import java.util.Scanner;

public class MenuLoop {

    private final MenuTextRenderer menuTextRenderer;
    private final Scanner scanner;

    public MenuLoop(MenuTextRenderer menuTextRenderer, Scanner scanner) {
        this.menuTextRenderer = menuTextRenderer;
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            menuTextRenderer.renderStartMenu();

            final String inputStringFromConsole = scanner.nextLine();
            if (inputStringFromConsole.equals(Constants.EXIT_COMMAND)) {
                return;
            } else if (inputStringFromConsole.equals(Constants.START_COMMAND)) {
                initAndStartGameLoop();
            } else {
                menuTextRenderer.renderWrongCommand();
            }
        }
    }

    private void initAndStartGameLoop() {
        final WordService wordService = new WordServiceDefaultImpl(new WordsRepositoryInFile());
        final HiddenWord hiddenWord = new HiddenWord(wordService.getRandomWord());
        final HangmanRenderer hangmanRenderer = new HangmanRenderer(hiddenWord);
        final GameTextRenderer gameTextRenderer = new GameTextRenderer(hiddenWord, hangmanRenderer);
        final Validator validator = new Validator();

        new GameLoop(hiddenWord, gameTextRenderer, validator, scanner).start();
    }
}
