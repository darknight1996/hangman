package org.example;

import org.example.constants.Constants;
import org.example.model.HiddenWord;
import org.example.render.GameTextRenderer;
import org.example.render.HangmanRenderer;
import org.example.render.MenuTextRenderer;
import org.example.repository.impl.WordsRepositoryInFile;
import org.example.service.WordService;
import org.example.service.impl.WordServiceDefaultImpl;
import org.example.validator.CharValidator;

import java.util.Scanner;

public class Game {
    private final Scanner scanner;

    public Game() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        menuLoop();
    }

    private void menuLoop() {
        final MenuTextRenderer menuTextRenderer = new MenuTextRenderer();
        while (true) {
            menuTextRenderer.renderStartMenu();

            final String inputStringFromConsole = scanner.nextLine();
            if (inputStringFromConsole.equals(Constants.EXIT_COMMAND)) {
                return;
            } else if (inputStringFromConsole.equals(Constants.START_COMMAND)) {
                gameLoop();
            } else {
                menuTextRenderer.renderWrongCommand();
            }
        }
    }

    private void gameLoop() {
        final WordService wordService = new WordServiceDefaultImpl(new WordsRepositoryInFile());
        final HiddenWord hiddenWord = new HiddenWord(wordService.getRandomWord());
        final HangmanRenderer hangmanRenderer = new HangmanRenderer(hiddenWord);
        final GameTextRenderer gameTextRenderer = new GameTextRenderer(hiddenWord, hangmanRenderer);
        final CharValidator charValidator = new CharValidator();

        while (true) {
            gameTextRenderer.renderGuessCharText();

            final String inputStringFromConsole = scanner.nextLine().toLowerCase();
            if (inputStringFromConsole.length() != 1) {
                gameTextRenderer.renderInvalidInputStringText();
                continue;
            }

            final char inputChar = inputStringFromConsole.charAt(0);
            if (charValidator.isValid(inputChar)) {
                hiddenWord.tryToGuess(inputChar);
            } else {
                gameTextRenderer.renderInvalidCharText();
                continue;
            }

            if (hiddenWord.getWrongChars().size() == Constants.ERRORS_TO_LOSE) {
                gameTextRenderer.renderLostText();
                return;
            }
            if (!hiddenWord.getWordWithMask().contains(Constants.HIDDEN_CHAR_MASK)) {
                gameTextRenderer.renderWonText();
                return;
            }
        }
    }

}
