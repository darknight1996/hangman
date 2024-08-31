package org.example.factory;

import org.example.content.GameContent;
import org.example.content.HangmanContent;
import org.example.game.Game;
import org.example.menu.Menu;
import org.example.model.HiddenWord;
import org.example.repository.WordsRepository;
import org.example.repository.impl.WordsRepositoryInFile;
import org.example.service.WordService;
import org.example.service.impl.RandomWordService;

import java.io.File;

public class ObjectFactory {

    public Game getGame() {
        return new Game(getHiddenWord(), getGameContent());
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
        return new HiddenWord(getWordService().getWord());
    }

    private WordService getWordService() {
        return new RandomWordService(getWordsRepository());
    }

    private WordsRepository getWordsRepository() {
        final String dataFilePath = "src" + File.separator + "main" + File.separator + "resources" +
                File.separator + "words.txt";
        return new WordsRepositoryInFile(dataFilePath);
    }

}
