package org.example;

import org.example.factory.ObjectFactory;
import org.example.menu.Menu;

public class Main {
    public static void main(String[] args) {
        final Menu menu = ObjectFactory.getInstance().getMenu();
        menu.start();
    }
}