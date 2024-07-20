package org.example.factory;

import org.example.game.Game;
import org.example.menu.Menu;
import org.example.model.HiddenWord;
import org.example.content.GameContent;
import org.example.content.HangmanContent;
import org.example.repository.WordsRepository;
import org.example.repository.impl.WordsRepositoryInFile;
import org.example.service.WordService;
import org.example.service.impl.WordServiceDefaultImpl;

public class ObjectFactory {

    public Game getGame() {
        final HiddenWord hiddenWord = getHiddenWord();
        final GameContent gameContent = getGameContent();

        return new Game(hiddenWord, gameContent);
    }

    public Menu getMenu() {
        return new Menu();
    }

    private GameContent getGameContent() {
        return new GameContent(getHangmanContent());
    }

    private HangmanContent getHangmanContent() {
        return new HangmanContent();
    }

    private HiddenWord getHiddenWord() {
        return new HiddenWord(getWordService().getRandomWord());
    }

    private WordService getWordService() {
        return new WordServiceDefaultImpl(getWordsRepository());
    }

    private WordsRepository getWordsRepository() {
        return new WordsRepositoryInFile();
    }
}
