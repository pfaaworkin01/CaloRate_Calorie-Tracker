package Food;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static Global.Global.waitForAnyKey;

public class FoodList {

    private static final String FILE_PATH = "Food_Item_List.txt";

    public void showList() {
        List<String[]> foodItems = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 3) {
                    foodItems.add(parts);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return;
        }

        foodItems.sort((a, b) -> a[0].compareToIgnoreCase(b[0]));

        System.out.println("+-----------------------------------+--------------------+--------------------+");
        System.out.printf("%-35s %-20s %-21s|%n", "|            Food Name", "|   Weight Per Unit", "|   Calorie Count");
        System.out.println("+-----------------------------------+--------------------+--------------------+");
        for (String[] item : foodItems) {
            System.out.printf("%-35s %-20s %-21s|%n", "| " + item[0], "| " + item[1], "| " + item[2]);
            System.out.println("+-----------------------------------+--------------------+--------------------+");
        }
        waitForAnyKey();
    }
}