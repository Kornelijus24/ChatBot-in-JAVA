import java.util.Scanner;

public class ChatUtils {

    // ANSI Color Codes for terminal text
    public static final String RESET = "\u001B[0m";  // Reset color
    public static final String BLUE = "\u001B[34m";  // Bot messages
    public static final String GREEN = "\u001B[32m"; // User input
    public static final String YELLOW = "\u001B[33m"; // Warnings
    public static final String RED = "\u001B[31m";    // Errors

    // Method to wait for user key press before continuing
    public static void waitForKeyPress(Scanner scanner) {
        System.out.println(YELLOW + "Press ENTER to continue..." + RESET);
        scanner.nextLine();
    }

    // Prints chatbot messages in blue
    public static void printBotMessage(String message) {
        System.out.println(BLUE + "CHATBOT: " + message + RESET);
    }

    // Prints user messages in green
    public static void printUserMessage(String message) {
        System.out.println(GREEN + "YOU: " + message + RESET);
    }

    // Prints errors in red
    public static void printError(String message) {
        System.out.println(RED + "ERROR: " + message + RESET);
    }

    // Prints warnings in yellow
    public static void printWarning(String message) {
        System.out.println(YELLOW + message + RESET);
    }

    // Simulates typing effect for chatbot messages
    public static void typeWriterEffect(String message, int delay) {
        System.out.print(BLUE + "CHATBOT: " + RESET);
        for (char c : message.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }

    // Reads user input and hides raw input from terminal
    public static String readAndPrintUserInput(Scanner scanner) {
        String input = scanner.nextLine().trim();
        System.out.print("\033[1A\033[2K"); // Move cursor up and clear the line AFTER input
        printUserMessage(input);
        return input;
    }
}
