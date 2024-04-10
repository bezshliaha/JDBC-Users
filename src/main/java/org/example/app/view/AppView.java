package org.example.app.view;

import org.example.app.utils.AppStarter;
import org.example.app.utils.Constants;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppView {
    Scanner scanner;
    int option;

    public int chooseOption() {
        scanner = new Scanner(System.in);
        showMenu();
        try {
            option = scanner.nextInt();

        } catch (InputMismatchException exception) {
            System.out.println(Constants.INCORRECT_VALUE_MSG);
            AppStarter.startApp();
        }
        return option;
    }

    private void showMenu() {
        System.out.print("""
                -----MENU-----
                1 - Create user
                2 - View all users
                3 - Update user's email
                4 - Delete user
                0 - Close app
                """);
    }

    public void getOutput(int choise, String output) {
        if (choise == 0) System.out.println(output);
        scanner.close();
        System.exit(0);
    }
}
