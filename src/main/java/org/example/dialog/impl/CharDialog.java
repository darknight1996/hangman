package org.example.dialog.impl;

import org.example.constants.Constants;
import org.example.dialog.Dialog;
import org.example.validator.Validator;

import java.util.Scanner;

public class CharDialog implements Dialog<Character> {

    private final String title;
    private final Scanner scanner = new Scanner(System.in);
    private final Validator validator = new Validator();

    public CharDialog(String title) {
        this.title = title;
    }

    @Override
    public Character input() {
        while (true) {
            System.out.println(title);

            final String inputString = scanner.nextLine();
            if (isSingleChar(inputString)) {
                return inputString.charAt(0);
            } else {
                System.out.println(Constants.INVALID_INPUT_STRING_TEXT);
            }
        }
    }

    private boolean isSingleChar(final String inputString) {
        return validator.isSingleChar(inputString);
    }
}
