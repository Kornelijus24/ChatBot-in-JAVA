import java.util.Random;
import java.util.Scanner;

public class ChatBot {
    private static String name;
    private static String mood = "neutral";
    private static final Random random = new Random();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            
            // Greeting and asking for name
            System.out.println("CHATBOT: Hello, I'm a ChatBot! What is your name?");
            name = scanner.nextLine();
            System.out.println("CHATBOT: Nice to meet you, " + name + "!\n");

            // Main menu
            while (true) {
                System.out.println("CHATBOT: What would you like to do?");
                System.out.println("1. Talk about something");
                System.out.println("2. Hear a joke");
                System.out.println("3. Play a game");
                System.out.println("4. Get a random fact");
                System.out.println("5. Calculate something");
                System.out.println("6. Exit");

                System.out.print("Your choice: ");
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        chatWithUser(scanner);
                        break;
                    case "2":
                        tellJoke();
                        break;
                    case "3":
                        playGame(scanner);
                        break;
                    case "4":
                        tellFact();
                        break;
                    case "5":
                        calculateSomething(scanner);
                        break;
                    case "6":
                        System.out.println("CHATBOT: Goodbye, " + name + "! Have a great day!\n");
                        return;
                    default:
                        System.out.println("CHATBOT: I didn't understand that. Please choose a number from the menu.");
                }
            }
        }
    }

    // Method to chat with the user based on their mood
    private static void chatWithUser(Scanner scanner) {
        System.out.println("CHATBOT: How are you feeling today?");
        String userFeeling = scanner.nextLine().toLowerCase();
        updateMood(userFeeling);

        // Chat based on user's mood
        switch (mood) {
            case "happy":
                System.out.println("CHATBOT: That's great to hear, " + name + "! What made you happy today?");
                scanner.nextLine();
                System.out.println("CHATBOT: That sounds wonderful!");
                System.out.println("CHATBOT: Do you want to share any recent exciting events?");
                scanner.nextLine();
                System.out.println("CHATBOT: That sounds amazing! I'm glad you're enjoying yourself!");
                break;
            case "sad":
                System.out.println("CHATBOT: Oh no, " + name + ". I'm here to cheer you up! Want to hear a joke? (yes/no)");
                if (scanner.nextLine().equalsIgnoreCase("yes")) {
                    tellJoke();
                } else {
                    System.out.println("CHATBOT: That's okay! If you ever need cheering up, I'm here for you.");
                }
                System.out.println("CHATBOT: What usually makes you feel better when you're down?");
                scanner.nextLine();
                System.out.println("CHATBOT: That’s a great way to lift your spirits! Stay positive!");
                break;
            default:
                System.out.println("CHATBOT: I see, " + name + ". Tell me more about it!");
                scanner.nextLine();
                System.out.println("CHATBOT: That is interesting! Thanks for sharing, " + name + ".");
                break;
        }

        // Chat about hobbies or interests
        System.out.println("CHATBOT: Do you want to discuss hobbies or interests? (yes/no)");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                System.out.println("CHATBOT: What hobbies or activities do you enjoy?");
                scanner.nextLine();
                System.out.println("CHATBOT: That sounds fun! It's always great to have activities that bring joy.");
            } else {
                System.out.println("CHATBOT: No worries! We can talk about anything you like!");
            }
    }

    // Method to play a number guessing game
    private static void playGame(Scanner scanner) {
        System.out.println("\nCHATBOT: Let's play a number guessing game! I'm thinking of a number between 1 and 10.");
        int numberToGuess = random.nextInt(10) + 1;
        int attempts = 3;

        while (attempts > 0) {
            System.out.print("CHATBOT: Take a guess: ");
            int userGuess = scanner.nextInt();
            scanner.nextLine();

            if (userGuess == numberToGuess) {
                System.out.println("CHATBOT: Congratulations, " + name + "! You guessed it right!\n");
                return;
            } else {
                System.out.println("CHATBOT: Nope, try again! You have " + (--attempts) + " attempts left.");
            }
        }
        System.out.println("CHATBOT: Sorry, " + name + ", the correct number was " + numberToGuess + ". Better luck next time!\n");
    }

    // Method to tell a random joke
    private static void tellJoke() {
        String[] jokes = {
            "CHATBOT: Why do Java developers wear glasses? Because they don’t see sharp! 🤓",
            "CHATBOT: What did one ocean say to the other ocean? Nothing, they just waved!",
            "CHATBOT: Why was the math book sad? It had too many problems.",
            "CHATBOT: Why do programmers prefer dark mode? Because light attracts bugs! 🪲",
            "CHATBOT: Why was the JavaScript developer sad? Because he didn’t ‘null’ his feelings properly.",
            "CHATBOT: What’s a programmer’s favorite type of music? Algo-rhythm! 🎵"
        };
        System.out.println(jokes[random.nextInt(jokes.length)] + "\n");
    }

    // Method to tell a random fact
    private static void tellFact() {
        String[] facts = {
            "CHATBOT: Did you know? Honey never spoils. Archaeologists found 3000-year-old honey in Egyptian tombs!",
            "CHATBOT: Did you know? The Eiffel Tower can be 15 cm taller during the summer due to thermal expansion.",
            "CHATBOT: Did you know? Octopuses have three hearts and blue blood!",
            "CHATBOT: Did you know? The first computer virus was created in 1986 and was called 'Brain'.",
            "CHATBOT: Did you know? A day on Venus is longer than a year on Venus!"
        };
        System.out.println(facts[random.nextInt(facts.length)] + "\n");
    }

    // Method to update mood based on user input
    private static void updateMood(String userFeeling) {
        if (userFeeling.contains("happy") || userFeeling.contains("great") || userFeeling.contains("good")) {
            mood = "happy";
        } else if (userFeeling.contains("sad") || userFeeling.contains("bad") || userFeeling.contains("upset")) {
            mood = "sad";
        } else {
            mood = "neutral";
        }
    }

    // Method to calculate addition, subtraction, multiplication, and division
    private static void calculateSomething(Scanner scanner) {
        System.out.println("CHATBOT: What would you like to calculate?");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Your choice: ");
        
        String choice = scanner.nextLine();
        
        if (!choice.matches("[1-4]")) {
            System.out.println("CHATBOT: I didn't understand that. Please choose a number from the menu.\n");
            return;
        }
        
        System.out.print("Enter first number: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("CHATBOT: Please enter a valid number.");
            scanner.next();
        }
        double num1 = scanner.nextDouble();
        
        System.out.print("Enter second number: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("CHATBOT: Please enter a valid number.");
            scanner.next();
        }
        double num2 = scanner.nextDouble();
        scanner.nextLine();

        switch (choice) {
            case "1":
                System.out.println("CHATBOT: The sum of " + num1 + " and " + num2 + " is " + (num1 + num2) + "\n");
                break;
            case "2":
                System.out.println("CHATBOT: The difference between " + num1 + " and " + num2 + " is " + (num1 - num2) + "\n");
                break;
            case "3":
                System.out.println("CHATBOT: The multiplication of " + num1 + " and " + num2 + " is " + (num1 * num2) + "\n");
                break;
            case "4":
                if (num2 == 0) {
                    System.out.println("CHATBOT: Cannot divide by zero!\n");
                } else {
                    System.out.println("CHATBOT: The division of " + num1 + " by " + num2 + " is " + (num1 / num2) + "\n");
                }
                break;
        }
    }
}
