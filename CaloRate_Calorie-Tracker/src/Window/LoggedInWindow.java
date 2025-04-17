package Window;

import Calorie.CalorieManager;

import static Global.Global.*;

public class LoggedInWindow extends Window {

    @Override
    void windowInterface() {
        windowTitle = "Logged In as \"" + LOGGED_IN_USERNAME + "\"";
        numberOfWindowOptions = 4;
        windowOptionTexts = "User Data:Calculate Calorie:Check Food List:Log Out";
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
                    UserDataWindow userDataManipulationWindow = new UserDataWindow();
                    userDataManipulationWindow.windowLogic();
                    break;
                case 2:
                    System.out.println();
                    CalorieManager calorieManager = new CalorieManager();
                    calorieManager.calculateCalorie();
                    break;
                case 3:
                    System.out.println();
//                    FoodList foodList = new FoodList();
//                    foodList.showList();
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
}