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
             System.out.println("CHATBOT ERROR: " + e.getMessage());
         } finally {
             System.out.println("CHATBOT: Exiting the program. Have a great day!");
         }
     }
 
     // Starts the chatbot, asks for user's name, and displays menu
     public void start() {
         System.out.println("CHATBOT: Hello, I'm a ChatBot!");
         System.out.println("CHATBOT: I can chat with you about different topics, tell you an interesting fact, and even play a number guessing game!");
         System.out.println("CHATBOT: Also, I can do basic maths calculations and tell you a joke to make you smile!");
         System.out.println("CHATBOT: Let's get started. What is your name?");
         
         try {
             user.setName(scanner.nextLine());
         } catch (IllegalArgumentException e) {
             System.out.println("CHATBOT ERROR: " + e.getMessage());
             return; // Stop execution if name is invalid
         }
 
         System.out.println("CHATBOT: Nice to meet you, " + user.getName() + "!");
         ChatUtils.waitForKeyPress(scanner);
 
         while (true) {
             displayMenu();
             String choice = scanner.nextLine();
 
             try {
                 handleUserChoice(choice);
             } catch (ChatException e) {
                 System.out.println("CHATBOT ERROR: " + e.getMessage());
             } catch (Exception e) {
                 System.out.println("CHATBOT ERROR: An unexpected error occurred.");
             }
 
             if (choice.equals("6")) {
                 break;
             }
         }
 
         System.out.println("CHATBOT: Goodbye, " + user.getName() + "! Have a great day!\n");
     }
 
     // Displays the chatbot menu
     private void displayMenu() {
         System.out.println("\nCHATBOT: What would you like to do?");
         System.out.println("1. Talk about something");
         System.out.println("2. Hear a joke");
         System.out.println("3. Play a game");
         System.out.println("4. Get a random fact");
         System.out.println("5. Calculate something");
         System.out.println("6. Exit");
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
 