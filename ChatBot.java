import java.util.Scanner;

public class ChatBot {
    private final Scanner scanner;
    private final User user;
    private final Game game;
    private final Calculator calculator;
    private final JokeProvider jokeProvider;
    private final FactProvider factProvider;
    private final ChatSession chatSession;

    // Constructor
    public ChatBot() {
        this.scanner = new Scanner(System.in);
        this.user = new User();
        this.game = new Game(scanner);
        this.calculator = new Calculator(scanner);
        this.jokeProvider = new JokeProvider();
        this.factProvider = new FactProvider();
        this.chatSession = new ChatSession(scanner, user, jokeProvider);
    }

    // Entry point (main function)
    public static void main(String[] args) {
        try {
            ChatBot chatbot = new ChatBot();
            chatbot.start();
        } catch (Exception e) {
            ChatUtils.printError("CHATBOT ERROR: " + e.getMessage());
        } finally {
            ChatUtils.typeWriterEffect(ChatUtils.RED + "Exiting the program." + ChatUtils.RESET, 50);
        }
    }

    // Starts the chatbot, asks for user's name, and displays menu
    public void start() {
        System.out.println("\n==================================================");
        ChatUtils.typeWriterEffect("|        Welcome to ChatBot!            |", 40);
        System.out.println("==================================================");
        ChatUtils.typeWriterEffect("| Hello! I'm a ChatBot. Let's have fun! |", 40);
        ChatUtils.typeWriterEffect("| I can chat, tell jokes, play games,   |", 40);
        ChatUtils.typeWriterEffect("| give facts, and do calculations!      |", 40);
        ChatUtils.typeWriterEffect("| Let's get started. What is your name? |", 40);
        System.out.println("==================================================");

        try {
            user.setName(ChatUtils.readAndPrintUserInput(scanner));
        } catch (IllegalArgumentException e) {
            ChatUtils.printError(e.getMessage());
            return; // Stop execution if name is invalid
        }

        ChatUtils.typeWriterEffect(ChatUtils.BLUE +"Nice to meet you, " + user.getName() + "!", 50);
        ChatUtils.waitForKeyPress(scanner);

        while (true) {
            displayMenu();
            String choice = ChatUtils.readAndPrintUserInput(scanner);

            try {
                handleUserChoice(choice);
            } catch (ChatException e) {
                ChatUtils.printError(e.getMessage());
            } catch (Exception e) {
                ChatUtils.printError("An unexpected error occurred.");
            }

            if (choice.equals("6")) break;
        }

        ChatUtils.typeWriterEffect(ChatUtils.BLUE + "Goodbye, " + user.getName() + "! Have a great day!", 50);
    }

    // Displays the chatbot menu
    private void displayMenu() {
        System.out.println("\n================================");
        System.out.println("         CHATBOT MENU ");
        System.out.println("================================");
        System.out.println("| 1. Talk about something      |");
        System.out.println("| 2. Hear a joke               |");
        System.out.println("| 3. Play a game               |");
        System.out.println("| 4. Get a random fact         |");
        System.out.println("| 5. Calculate something       |");
        System.out.println("| 6. Exit                      |");
        System.out.println("================================");
        System.out.print("Your choice: ");
    }

    // Handles user input from the menu
    private void handleUserChoice(String choice) throws ChatException {
        switch (choice) {
            case "1":
                chatSession.chatWithUser();
                break;
            case "2":
                jokeProvider.tellJoke();
                ChatUtils.waitForKeyPress(scanner);
                break;
            case "3":
                game.play();
                break;
            case "4":
                factProvider.tellFact();
                ChatUtils.waitForKeyPress(scanner);
                break;
            case "5":
                calculator.performCalculation();
                break;
            case "6":
                break;
            default:
                throw new ChatException("Invalid choice! Please select a valid menu option.");
        }
    }
}
