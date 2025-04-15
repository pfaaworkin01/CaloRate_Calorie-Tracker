package User;

import java.io.*;
import static Global.Global.*;

public class UserDataManager {

    private static final String USER_DATA = "User_Data.txt";

    public void saveUserData(String username, String gender, String weight, String height, String age, String activityLevel, String goal) {
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

                writer.write(username + ":" + gender + ":" + weight + ":" + height + ":" + age + ":" + activityLevel + ":" + goal + "\n");

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
                    if (parts.length == 7) {
                        System.out.println();
                        System.out.println("Your Data:");
                        System.out.println("+----------------+----------------+");
                        System.out.printf("| %-14s | %-14s |\n", "Field", "Value");
                        System.out.println("+----------------+----------------+");
                        System.out.printf("| %-14s | %-14s |\n", "Gender", parts[1]);
                        System.out.printf("| %-14s | %-14s |\n", "Weight", parts[2] + " kg");
                        System.out.printf("| %-14s | %-14s |\n", "Height", parts[3] + " cm");
                        System.out.printf("| %-14s | %-14s |\n", "Age", parts[4] + " years");
                        System.out.printf("| %-14s | %-14s |\n", "Activity Level", parts[5]);
                        System.out.printf("| %-14s | %-14s |\n", "Goal", parts[6]);
                        System.out.println("+----------------+----------------+");
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
}
