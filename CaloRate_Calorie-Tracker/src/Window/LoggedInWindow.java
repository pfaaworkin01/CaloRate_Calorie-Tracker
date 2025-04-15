package Window;

import static Global.Global.*;

public class LoggedInWindow extends Window {

    @Override
    void windowInterface() {
        windowTitle = "Logged In as \"" + LOGGED_IN_USERNAME + "\"";
        numberOfWindowOptions = 3;
        windowOptionTexts = "User Data:Calculate Calorie:Go Back";
        super.windowInterface();
    }

    @Override
    public void windowLogic() {
        numberOfWindowOptions = 3;

        while (!quitWindow) {
            System.out.println();
            super.windowLogic();

            System.out.println();
            printCentered("Select an option: ");

            while (!scanner.hasNextInt()) {
                printCentered("Invalid input! Please enter a number.", YELLOW_TEXT);
                scanner.nextLine();
            }
            selection = scanner.nextInt();
            scanner.nextLine();

            switch (selection) {
                case 1:
                    System.out.println();
                    UserDataManipulationWindow userDataManipulationWindow = new UserDataManipulationWindow();
                    userDataManipulationWindow.windowLogic();
                    break;
                case 2:
                    System.out.println();
                    printCentered("Calculating Calorie...");
                    break;
                case 3:
                    quitWindow = true;
                    break;
                default:
                    System.out.println();
                    printCentered("Invalid selection. Try again", YELLOW_TEXT);
                    break;
            }
        }
    }
}