package Window;

import java.util.Scanner;

import static Global.Global.*;

public abstract class Window {

    String windowTitle;
    boolean quitWindow = false;
    int numberOfWindowOptions;
    String windowOptionTexts;
    int selection;
    Scanner scanner = new Scanner(System.in);

    void windowInterface() {
        printHeaderPart(windowTitle);
        printCenteredWindowOptions(numberOfWindowOptions, windowOptionTexts);
    }
    void windowLogic() {
        windowInterface();
    }

    public void printHeaderPart(String windowTitle) {
        System.out.println("*".repeat(149));

        System.out.print(GREEN_BACKGROUND + BLACK_TEXT + BOLD_TEXT);
        printCenteredHeaderTitles("CaloRate");
        System.out.println(RESET_ANSI_CODES);

        System.out.print(GREEN_BACKGROUND + BLACK_TEXT);
        printCenteredHeaderTitles("Savor the Flavors of Health");
        System.out.println(RESET_ANSI_CODES);

        System.out.println("*".repeat(149));
        printCenteredWindowTitle(windowTitle, GREEN_TEXT);
        System.out.println();
    }

    public void printCenteredHeaderTitles(String text) {
        int terminalWidth = 149;
        int padding = (terminalWidth - text.length()) / 2;
        System.out.print(" ".repeat(padding) + text + (padding % 2 == 0 ? " ".repeat(padding + 1) : " ".repeat(padding)));
    }

    public void printCenteredWindowOptions(int windowOptions, String windowOptionTexts) {
        String[] optionText = windowOptionTexts.split(":");
        System.out.println();
        for (int i = 0; i < windowOptions; i++) {
            int padding = 68;
            int optionNumber = i + 1;
            System.out.print(" ".repeat(padding) + optionNumber + ". " + optionText[i] + "\n");
        }
    }

    public void printCenteredWindowTitle(String text, String textColor) {
        int terminalWidth = 149;
        int padding = ((terminalWidth - text.length()) / 2) - 4;
        System.out.print(" ".repeat(Math.max(0, padding)) + textColor + "<<< " + RESET_ANSI_CODES + text + GREEN_TEXT + " >>>" + RESET_ANSI_CODES);
    }

}
