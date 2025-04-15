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
    void windowLogic() {
        numberOfWindowOptions = 3;
        super.windowLogic();

        while(!quitWindow) {
            System.out.println();
            int terminalWidth = 149;
            int padding = (terminalWidth - "Select an option: ".length()) / 2;
            System.out.print(" ".repeat(padding) + "Select an option: ");
            while(!scanner.hasNextInt()) {
                printCentered("Invalid input! Please enter a number.", YELLOW_TEXT);
                scanner.nextLine();
            }
            selection = scanner.nextInt();
            scanner.nextLine();

            switch(selection) {
                case 1:
                    //register;
                    break;
                case 2:
                    //login;
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
