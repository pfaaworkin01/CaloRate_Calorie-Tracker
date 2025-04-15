package Window;

import AccessControl.Login;
import AccessControl.Register;

import static Global.Global.YELLOW_TEXT;
import static Global.Global.printCentered;

public class HomeWindow extends Window {

    @Override
    void windowInterface() {
        windowTitle = "Home";
        numberOfWindowOptions = 3;
        windowOptionTexts = "Register:Login:Quit";
        super.windowInterface();
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
