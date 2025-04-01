public class Global {

    public static final String RESET_ANSI_CODES = "\u001B[0m";
    public static final String BOLD_TEXT = "\u001B[1m";
    public static final String BLACK_TEXT = "\u001B[30m";
    public static final String RED_TEXT = "\u001B[31m";
    public static final String BLUE_TEXT = "\u001B[34m";
    public static final String YELLOW_TEXT = "\u001B[33m";
    public static final String GREEN_TEXT = "\u001B[32m";
    public static final String BLUE_BACKGROUND = "\u001B[44m";
    public static final String GREEN_BACKGROUND = "\033[42m";

    public static void printHeaderPart(String windowTitle) {
        System.out.println("*".repeat(140));
        System.out.print(GREEN_BACKGROUND + BLACK_TEXT + BOLD_TEXT);
        printCentered("CaloRate");
        System.out.print(RESET_ANSI_CODES + GREEN_BACKGROUND + BLACK_TEXT);
        printCentered("Savor the Flavors of Health");
        System.out.print(RESET_ANSI_CODES);
        System.out.println("*".repeat(140));
        printCenteredWindowTitle(windowTitle, GREEN_TEXT);
        System.out.println();
    }

    public static void printCenteredWindowTitle(String text, String textColor) {
        int terminalWidth = 140;
        int padding = ((terminalWidth - text.length()) / 2) - 4;
        System.out.print(" ".repeat(Math.max(0, padding)) + textColor + "<<< " + RESET_ANSI_CODES + text + GREEN_TEXT + " >>>" + RESET_ANSI_CODES);
    }

    public static void printCentered(String text) {
        int terminalWidth = 140;
        int padding = (terminalWidth - text.length()) / 2;
        System.out.println(" ".repeat(Math.max(0, padding)) + text);
    }

    public static void printCentered(String text, String textColor) {
        System.out.print(textColor);
        printCentered(text);
        System.out.print(RESET_ANSI_CODES);
    }

}
