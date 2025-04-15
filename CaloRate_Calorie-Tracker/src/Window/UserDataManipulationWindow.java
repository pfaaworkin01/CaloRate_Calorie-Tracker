package Window;

import User.UserDataManager;

import static Global.Global.*;

public class UserDataManipulationWindow extends Window {

    private final UserDataManager userDataManager = new UserDataManager();

    @Override
    void windowInterface() {
        windowTitle = "User Data Manipulation";
        numberOfWindowOptions = 3;
        windowOptionTexts = "Update Data:View Data:Go Back";
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
                    updateData();
                    break;
                case 2:
                    System.out.println();
                    UserDataManager userDataManager = new UserDataManager();
                    userDataManager.viewData();
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

    private void updateData() {
        printCentered("Enter your details below:");

        String gender = getInput("Enter your gender (M/F): ", "M", "F");
        String weight = getInput("Enter your weight in kg: ");
        String height = getInput("Enter your height in cm: ");
        String age = getInput("Enter your age in years: ");

        System.out.println();
        printCentered("Activity Levels:");
        System.out.println();
        System.out.println("+----------------+-------------------------+");
        System.out.printf("| %-14s | %-23s |\n", "Code", "Description");
        System.out.println("+----------------+-------------------------+");
        System.out.printf("| %-14s | %-23s |\n", "S", "Sedentary");
        System.out.printf("| %-14s | %-23s |\n", "L", "Lightly Active");
        System.out.printf("| %-14s | %-23s |\n", "M", "Moderately Active");
        System.out.printf("| %-14s | %-23s |\n", "V", "Very Active");
        System.out.printf("| %-14s | %-23s |\n", "E", "Extremely Active");
        System.out.println("+----------------+-------------------------+");

        String activityLevel = getInput("Enter your activity level (S/L/M/V/E): ", "S", "L", "M", "V", "E");

        System.out.println();
        printCentered("Goals:");
        System.out.println();
        System.out.println("+----------------+-------------------------+");
        System.out.printf("| %-14s | %-23s |\n", "Code", "Description");
        System.out.println("+----------------+-------------------------+");
        System.out.printf("| %-14s | %-23s |\n", "M", "Maintain Weight");
        System.out.printf("| %-14s | %-23s |\n", "G", "Gain Weight");
        System.out.printf("| %-14s | %-23s |\n", "L", "Lose Weight");
        System.out.println("+----------------+-------------------------+");

        String goal = getInput("Enter your goal (M/G/L): ", "M", "G", "L");

        userDataManager.saveUserData(LOGGED_IN_USERNAME, gender, weight, height, age, activityLevel, goal);

        System.out.println();
        printCentered("User data updated successfully!", GREEN_TEXT);
        waitForAnyKey();
    }

    private String getInput(String prompt, String... validOptions) {
        String input;
        while (true) {
            System.out.println();
            printCentered(prompt);
            input = scanner.nextLine().trim().toUpperCase();

            if (validOptions.length == 0 || isValidOption(input, validOptions)) {
                break;
            } else {
                printCentered("Invalid input! Please try again.", YELLOW_TEXT);
            }
        }
        return input;
    }

    private boolean isValidOption(String input, String[] validOptions) {
        for (String option : validOptions) {
            if (input.equals(option)) {
                return true;
            }
        }
        return false;
    }
}
