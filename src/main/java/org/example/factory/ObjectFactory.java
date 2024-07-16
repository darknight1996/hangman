package org.example.factory;

import org.example.game.Game;
import org.example.menu.Menu;
import org.example.model.HiddenWord;
import org.example.content.GameContent;
import org.example.content.HangmanContent;
import org.example.content.MenuContent;
import org.example.repository.impl.WordsRepositoryInFile;
import org.example.service.WordService;
import org.example.service.impl.WordServiceDefaultImpl;

public final class ObjectFactory {

    private static final ObjectFactory objectFactory = new ObjectFactory();

    public static ObjectFactory getInstance() {
        return objectFactory;
    }

    public Game getGame() {
        final WordService wordService = new WordServiceDefaultImpl(new WordsRepositoryInFile());
        final HiddenWord hiddenWord = new HiddenWord(wordService.getRandomWord());
        final HangmanContent hangmanContent = new HangmanContent();
        final GameContent gameContent = new GameContent(hiddenWord, hangmanContent);

        return new Game(hiddenWord, gameContent);
    }

    public Menu getMenu() {
        final MenuContent menuContent = new MenuContent();
        return new Menu(menuContent);
    }
}
