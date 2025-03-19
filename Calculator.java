import java.util.Scanner;

public class Calculator {
    private final Scanner scanner;

    public Calculator(Scanner scanner) {
        this.scanner = scanner;
    }

    public void performCalculation() {
        // Display calculator menu
        System.out.println(ChatUtils.BLUE + "\n==========================================");
        System.out.println("          CALCULATOR MENU          ");
        System.out.println("==========================================" + ChatUtils.RESET);
        ChatUtils.typeWriterEffect(ChatUtils.BLUE + "| 1) Add                        |" + ChatUtils.RESET, 30);
        ChatUtils.typeWriterEffect(ChatUtils.BLUE + "| 2) Subtract                   |" + ChatUtils.RESET, 30);
        ChatUtils.typeWriterEffect(ChatUtils.BLUE + "| 3) Multiply                   |" + ChatUtils.RESET, 30);
        ChatUtils.typeWriterEffect(ChatUtils.BLUE + "| 4) Divide                     |" + ChatUtils.RESET, 30);
        System.out.println(ChatUtils.BLUE + "==========================================" + ChatUtils.RESET);

        String choice;
        while (true) {
            ChatUtils.typeWriterEffect(ChatUtils.YELLOW + "Choose an operation (1-4): " + ChatUtils.RESET, 30);
            choice = scanner.nextLine().trim();
            if (choice.matches("[1-4]")) break;
            ChatUtils.printError("Invalid operation choice. Please enter a number between 1 and 4.");
        }

        double num1 = getValidNumber("Enter first number: ");
        double num2 = getValidNumber("Enter second number: ");

        try {
            String resultMessage = "";

            switch (choice) {
                case "1":
                    resultMessage = "Result: " + (num1 + num2);
                    break;
                case "2":
                    resultMessage = "Result: " + (num1 - num2);
                    break;
                case "3":
                    resultMessage = "Result: " + (num1 * num2);
                    break;
                case "4":
                    while (num2 == 0 || num1 == 0) { // Prevent division by zero
                        ChatUtils.printError("Cannot divide by zero! Enter new numbers.");
                        num1 = getValidNumber("Enter first number: ");
                        num2 = getValidNumber("Enter second number: ");
                    }
                    resultMessage = "Result: " + (num1 / num2);
                    break;
            }

            ChatUtils.typeWriterEffect(ChatUtils.GREEN + resultMessage + ChatUtils.RESET, 40);

        } catch (Exception e) {
            ChatUtils.printError("CHATBOT ERROR: Something went wrong.");
        }

        ChatUtils.waitForKeyPress(scanner);
    }

    // Method to keep asking for a valid number
    private double getValidNumber(String message) {
        while (true) {
            ChatUtils.typeWriterEffect(ChatUtils.YELLOW + message + ChatUtils.RESET, 30);
            if (scanner.hasNextDouble()) {
                double number = scanner.nextDouble();
                scanner.nextLine();
                return number;
            } else {
                ChatUtils.printError("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }
}
