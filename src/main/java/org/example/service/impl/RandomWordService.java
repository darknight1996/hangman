package org.example.service.impl;

import org.example.repository.WordsRepository;
import org.example.service.WordService;

import java.util.List;
import java.util.Random;

public class RandomWordService implements WordService {

    private final WordsRepository wordsRepository;

    public RandomWordService(final WordsRepository wordsRepository) {
        this.wordsRepository = wordsRepository;
    }

    @Override
    public String getWord() {
        final List<String> words = wordsRepository.getAll();
        final Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }

}
