package AccessControl;

import java.util.Scanner;

import static Global.Global.*;

public class Login {

    CredentialManager loadCredentials = new CredentialManager();

    public void login() {
        String username = returnUsername();
        String password = returnPassword();
        loadCredentials.loadCredentials(username, password);
    }

    private String returnUsername() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        printCentered("Enter username: ");
        return scanner.nextLine();
    }

    private String returnPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        printCentered("Enter password: ");
        return scanner.nextLine();
    }
}
