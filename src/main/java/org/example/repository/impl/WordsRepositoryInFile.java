package org.example.repository.impl;

import org.example.constants.Constants;
import org.example.repository.WordsRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordsRepositoryInFile implements WordsRepository {

    @Override
    public List<String> getAll() {
        final Scanner scanner;
        final List<String> words = new ArrayList<>();

        try {
            scanner = new Scanner(new File(Constants.DATA_FILE_PATH));
            while (scanner.hasNext()) {
                words.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.fillInStackTrace();
        }

        return words;
    }
}
