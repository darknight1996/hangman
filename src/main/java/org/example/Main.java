package org.example;

import org.example.factory.ObjectFactory;
import org.example.menu.Menu;

public class Main {

    public static void main(String[] args) {
        final ObjectFactory objectFactory = new ObjectFactory();
        final Menu menu = objectFactory.getMenu();
        menu.start();
    }
}