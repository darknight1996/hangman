package org.example.repository.impl;

import org.example.repository.WordsRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordsRepositoryInFile implements WordsRepository {

    private final String dataFilePath;

    public WordsRepositoryInFile(final String dataFilePath) {
        this.dataFilePath = dataFilePath;
    }

    @Override
    public List<String> getAll() {
        final List<String> words = new ArrayList<>();

        try (final Scanner scanner = new Scanner(new File(dataFilePath))) {
            while (scanner.hasNext()) {
                words.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.fillInStackTrace();
        }

        return words;
    }

}
