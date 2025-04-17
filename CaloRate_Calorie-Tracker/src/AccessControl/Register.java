package AccessControl;

import java.util.Scanner;

import static Global.Global.*;

public class Register {

    Scanner scanner = new Scanner(System.in);
    CredentialManager credentialManager = new CredentialManager();

    public void register() {
        Scanner scanner = new Scanner(System.in);
        String username = receiveUsername();

        if (credentialManager.checkUsernameAvailability(username)) {
            String password = receivePassword();

            while (!password.isEmpty()) {
                System.out.println();
                printCentered("Are you sure you want to register as '" + username + "'? (Y/N): ");
                String confirmRegistration = scanner.nextLine();
                if (confirmRegistration.equalsIgnoreCase("N")) {
                    System.out.println();
                    printCentered("!!! Registration cancelled !!!", YELLOW_TEXT);
                    waitForAnyKey();
                    return;
                } else if (confirmRegistration.equalsIgnoreCase("Y")) {
                    credentialManager.saveCredentials(username, password);
                    return;
                } else {
                    System.out.println();
                    printCentered("!!! Invalid input. Please enter 'Y' or 'N' !!!", YELLOW_TEXT);
                }
            }
        }
        else {
            System.out.println();
            printCentered("!!! Username already exists. Try something different !!!", YELLOW_TEXT);
            register();
        }
    }

    private String receiveUsername() {
        System.out.println();
        printCentered("Enter Username: ");
        String username = scanner.nextLine();
        if (!username.matches("[a-zA-Z0-9]+")) {
            System.out.println();
            printCentered("!!! Invalid Username. Only alphanumeric characters are allowed !!!", YELLOW_TEXT);
            username = receiveUsername();
        }
        return username;
    }

    private String receivePassword() {
        System.out.println();
        printCentered("Enter Password: ");
        String inputPassword = scanner.nextLine();
        while (!inputPassword.matches("(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,15}")) {
            System.out.println();
            printCentered("!!!  Invalid Password  !!!", YELLOW_TEXT);
            printCentered("!!!  Password length must be between 8-15  !!!", YELLOW_TEXT);
            printCentered("!!!  Password also must contain at least one character from each of these groups (a-z), (A-Z), (0-9)  !!!\n", YELLOW_TEXT);
        }
        return inputPassword;
    }

}
