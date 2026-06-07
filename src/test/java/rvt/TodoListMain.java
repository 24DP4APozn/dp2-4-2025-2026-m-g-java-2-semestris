package rvt;

import java.util.Scanner;

public class TodoListMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TodoList list = new TodoList();

        UserInterface ui = new UserInterface(list, scanner);
        ui.start();
    }
}