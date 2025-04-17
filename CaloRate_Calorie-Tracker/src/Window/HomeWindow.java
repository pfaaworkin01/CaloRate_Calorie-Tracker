package Window;

import AccessControl.Login;
import AccessControl.Register;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import static Global.Global.*;

public class HomeWindow extends Window {

    @Override
    void windowInterface() {
        windowTitle = "Home";
        numberOfWindowOptions = 4;
        windowOptionTexts = "Register:Login:Refresh Quote:Quit";
        super.windowInterface();
        System.out.println();
        showHealthQuote();
    }

    @Override
    public void windowLogic() {
        numberOfWindowOptions = 3;

        while(!quitWindow) {
            System.out.println();
            super.windowLogic();

            System.out.println();
            printCentered("Select an option: ");

            while(!scanner.hasNextInt()) {
                printCentered("Invalid input! Please enter a number.", YELLOW_TEXT);
                scanner.nextLine();
            }
            selection = scanner.nextInt();
            scanner.nextLine();

            switch(selection) {
                case 1:
                    Register register = new Register();
                    register.register();
                    break;
                case 2:
                    Login login = new Login();
                    login.login();
                    if (AUTHENTICATED) {
                        LoggedInWindow loggedInWindow = new LoggedInWindow();
                        loggedInWindow.windowLogic();
                    }
                    break;
                case 3:
                    break;
                case 4:
                    quitWindow = true;
                    break;
                default:
                    System.out.println();
                    printCentered("Invalid selection. Try again", YELLOW_TEXT);
                    break;
            }
        }
    }

    private void showHealthQuote() {
        String filePath = "Health_Quotes.txt";
        List<String> quotes = new ArrayList<>();
        SecureRandom random = new SecureRandom();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                quotes.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return;
        }

        if (!quotes.isEmpty()) {
            String randomQuote = quotes.get(random.nextInt(quotes.size()));
            String[] parts = randomQuote.split(":");
            if (parts.length == 2) {
                System.out.println("\"" + GREEN_TEXT + parts[0] + RESET_ANSI_CODES + "\" - " + parts[1]);
            }
        }
    }
}
