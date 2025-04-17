package Calorie;

import User.UserDataManager;

import java.util.Scanner;

import static Global.Global.printCentered;
import static Global.Global.waitForAnyKey;

public class CalorieManager {

    private final CalorieCalculator calorieCalculator = new CalorieCalculator();
    private final UserDataManager userDataManager = new UserDataManager();
    private final Scanner scanner = new Scanner(System.in);

    public void calculateCalorie() {
        System.out.println();
        System.out.println("Select a meal type:");
        System.out.println("1. Breakfast");
        System.out.println("2. Lunch");
        System.out.println("3. Dinner");

        int choice = getValidChoice(1, 3);
        MealType mealType = getMealTypeFromChoice(choice);

        double BMR = userDataManager.getBMR();
        double activityLevelFactor = userDataManager.getActivityFactor();
        double calories = calorieCalculator.calculateCalories(mealType.name(), BMR, activityLevelFactor);

        printCentered("Estimated calories for " + mealType.name().toLowerCase() + ": " + String.format("%.2f", calories) + " kcal");
        waitForAnyKey();
        System.out.println();
    }

    private int getValidChoice(int min, int max) {
        int choice;
        while (true) {
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
            }
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice >= min && choice <= max) {
                break;
            } else {
                System.out.println("Invalid choice! Please select a valid option.");
            }
        }
        return choice;
    }

    private double getValidDouble() {
        double value;
        while (true) {
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine();
            }
        }
        return value;
    }

    private MealType getMealTypeFromChoice(int choice) {
        switch (choice) {
            case 1:
                return MealType.BREAKFAST;
            case 2:
                return MealType.LUNCH;
            case 3:
                return MealType.DINNER;
            default:
                throw new IllegalArgumentException("Invalid choice");
        }
    }
}