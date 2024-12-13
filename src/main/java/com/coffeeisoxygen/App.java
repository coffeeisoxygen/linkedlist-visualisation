package com.coffeeisoxygen;

import com.coffeeisoxygen.classes.linkedlists.manager.LinkedListManager;
import com.coffeeisoxygen.controllers.LinkedListController;
import com.coffeeisoxygen.views.LinkedListGUI;

public class App {

    public static void main(String[] args) {
        LinkedListManager manager = new LinkedListManager();
        LinkedListGUI view = new LinkedListGUI();
        new LinkedListController(manager, view);
    }
}
