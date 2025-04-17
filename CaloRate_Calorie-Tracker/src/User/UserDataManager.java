package User;

import java.io.*;
import static Global.Global.*;

public class UserDataManager {

    private static final String USER_DATA = "User_Data.txt";

    public void saveUserData(String username, String gender, String weight, String height, String age, String activityLevel, String goal, String BMR) {
        File file = new File(USER_DATA);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(file));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {

                StringBuilder updatedContent = new StringBuilder();
                String line;
                boolean userExists = false;

                while ((line = reader.readLine()) != null) {
                    if (line.startsWith(username + ":")) {
                        userExists = true;
                    } else {
                        updatedContent.append(line).append("\n");
                    }
                }

                if (userExists) {
                    try (BufferedWriter overwriteWriter = new BufferedWriter(new FileWriter(file))) {
                        overwriteWriter.write(updatedContent.toString());
                    }
                }

                writer.write(username + ":" + gender + ":" + weight + ":" + height + ":" + age + ":" + activityLevel + ":" + goal + ":" + BMR + "\n");

            }
        } catch (IOException e) {
            printCentered("Error saving user data. Please try again.", RED_TEXT);
        }
    }

    public void viewData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_DATA))) {
            String line;
            boolean dataFound = false;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");

                if (parts[0].equals(LOGGED_IN_USERNAME)) {
                    dataFound = true;
                    if (parts.length == 8) {
                        System.out.println();
                        System.out.println("Your Data:");
                        System.out.println("+----------------------+----------------------+");
                        System.out.printf("| %-20s | %-20s |\n", "Field", "Value");
                        System.out.println("+----------------------+----------------------+");
                        System.out.printf("| %-20s | %-20s |\n", "Gender", parts[1]);
                        System.out.printf("| %-20s | %-20s |\n", "Weight", parts[2] + " kg");
                        System.out.printf("| %-20s | %-20s |\n", "Height", parts[3] + " cm");
                        System.out.printf("| %-20s | %-20s |\n", "Age", parts[4] + " years");
                        System.out.printf("| %-20s | %-20s |\n", "Activity Level", parts[5]);
                        System.out.printf("| %-20s | %-20s |\n", "Goal", parts[6]);
                        System.out.printf("| %-20s | %-20s |\n", "BMR", parts[7] + " kcal/day");
                        System.out.println("+----------------------+----------------------+");
                    } else {
                        printCentered("Data format is invalid. Please update your data.", YELLOW_TEXT);
                    }
                    break;
                }
            }

            if (!dataFound) {
                printCentered("No data found for the current user.", YELLOW_TEXT);
            }
        } catch (IOException e) {
            printCentered("Error reading user data. Please try again.", RED_TEXT);
        }
        waitForAnyKey();
    }

    public double calculateBMR(String gender, String weight, String height, String age) {
        double BMR = 0.00;

        if(gender.equals("M")) {
            BMR = 88.362 + (13.397 * Double.parseDouble(weight)) + (4.799 * Double.parseDouble(height)) - (5.677 * Double.parseDouble(age));
        }
        else if(gender.equals("F")) {
            BMR = 447.593 + (9.247 * Double.parseDouble(weight)) + (3.098 * Double.parseDouble(height)) - (4.330 * Double.parseDouble(age));
        }

        return Double.parseDouble(String.format("%.2f", BMR));
    }

    public double getBMR() {
        double BMR = 0.00;
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_DATA))) {
            String line;
            boolean dataFound = false;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");

                if (parts[0].equals(LOGGED_IN_USERNAME)) {
                    dataFound = true;
                    if (parts.length == 8) {
                        BMR = Double.parseDouble(parts[7]);
                    } else {
                        printCentered("Data format is invalid. Please update your data.", YELLOW_TEXT);
                    }
                    break;
                }
            }

            if (!dataFound) {
                printCentered("No data found for the current user.", YELLOW_TEXT);
            }
        } catch (IOException e) {
            printCentered("Error reading user data. Please try again.", RED_TEXT);
        }

        return BMR;
    }

    public double getActivityFactor() {
        double activityFactor = 0.00;
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_DATA))) {
            String line;
            boolean dataFound = false;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");

                if (parts[0].equals(LOGGED_IN_USERNAME)) {
                    dataFound = true;
                    if (parts.length == 8) {
                        switch(parts[5]) {
                            case "S":
                                activityFactor = 1.2;
                                break;
                            case "L":
                                activityFactor = 1.375;
                                break;
                            case "M":
                                activityFactor = 1.55;
                                break;
                            case "V":
                                activityFactor = 1.725;
                                break;
                            case "E":
                                activityFactor = 1.9;
                                break;
                            default:
                                printCentered("Invalid activity level. Please update your data.", YELLOW_TEXT);
                        }
                    } else {
                        printCentered("Data format is invalid. Please update your data.", YELLOW_TEXT);
                    }
                    break;
                }
            }

            if (!dataFound) {
                printCentered("No data found for the current user.", YELLOW_TEXT);
            }
        } catch (IOException e) {
            printCentered("Error reading user data. Please try again.", RED_TEXT);
        }

        return activityFactor;
    }
}
