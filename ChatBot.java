import java.util.Random;
import java.util.Scanner;

public class ChatBot {
    private static String name;
    private static String mood = "neutral";
    private static final Random random = new Random();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            
            // Greeting and asking for name
            System.out.println("CHATBOT: Hello, I'm a ChatBot!");
            System.out.println("CHATBOT: I can chat with you about different topics, tell you an interesting fact, and even play a number guessing game!");
            System.out.println("CHATBOT: Also, I can do basic maths calculations and tell you a joke to make you smile!");
            System.out.println("CHATBOT: Let's get started. What is your name?");
            name = scanner.nextLine();
            System.out.println("CHATBOT: Nice to meet you, " + name + "!");

            // Wait for key press before showing the menu
            waitForKeyPress(scanner);

            // Main menu
            while (true) {
                System.out.println("CHATBOT: What would you like to do? Please choose an option from the menu!");
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
                        pause();
                        chatWithUser(scanner);
                        break;
                    case "2":
                        pause();
                        tellJoke();
                        waitForKeyPress(scanner);
                        break;
                    case "3":
                        pause();
                        playGame(scanner);
                        break;
                    case "4":
                        pause();
                        tellFact();
                        waitForKeyPress(scanner);
                        break;
                    case "5":
                        pause();
                        calculateSomething(scanner);
                        break;
                    case "6":
                        pause();
                        System.out.println("CHATBOT: Goodbye, " + name + "! Have a great day!\n");
                        return;
                    default:
                        System.out.println("CHATBOT: I didn't understand that. Please choose a number from the menu.");
                        waitForKeyPress(scanner);
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
                pause();
                System.out.println("CHATBOT: That's great to hear, " + name + "! What made you happy today?");
                scanner.nextLine();

                pause();
                System.out.println("CHATBOT: That sounds wonderful!");

                pause();
                String shareEvent;
                do {
                    System.out.println("CHATBOT: Do you want to share any recent exciting events? (yes/no)");
                    shareEvent = scanner.nextLine().toLowerCase();

                    if (shareEvent.equals("yes")) {
                        pause();
                        System.out.println("CHATBOT: Awesome! Tell me about it!");
                        scanner.nextLine();
                        pause();
                        System.out.println("CHATBOT: That sounds amazing! I'm glad you're enjoying yourself!");
                    } else if (shareEvent.equals("no")) {
                        pause();
                        System.out.println("CHATBOT: No worries! I'm just happy that you're feeling great!");
                    } else {
                        System.out.println("CHATBOT: I didn't understand that. Please answer with 'yes' or 'no'.");
                    }
                } while (!shareEvent.equals("yes") && !shareEvent.equals("no"));
                break;
            case "sad":
                pause();
                String jokeResponse;
                do {
                    System.out.println("CHATBOT: Oh no, " + name + ". I'm here to cheer you up! Want to hear a joke? (yes/no)");
                    jokeResponse = scanner.nextLine().toLowerCase();

                    if (jokeResponse.equals("yes")) {
                        pause();
                        tellJoke();
                    } else if (jokeResponse.equals("no")) {
                        pause();
                        System.out.println("CHATBOT: That's okay! If you ever need cheering up, I'm here for you.");
                    } else {
                        System.out.println("CHATBOT: I didn't understand that. Please answer with 'yes' or 'no'.");
                    }
                } while (!jokeResponse.equals("yes") && !jokeResponse.equals("no"));

                pause();
                System.out.println("CHATBOT: What usually makes you feel better when you're down?");
                scanner.nextLine();
                pause();
                System.out.println("CHATBOT: That’s a great way to lift your spirits! Stay positive!");
                break;
            default:
                pause();
                System.out.println("CHATBOT: I see, " + name + ". Tell me more about it!");
                scanner.nextLine();
                pause();
                System.out.println("CHATBOT: That is interesting! Thanks for sharing, " + name + ".");
                break;
        }

        // Chat about hobbies or interests
        pause();
        String hobbyResponse;
        do {
            System.out.println("CHATBOT: Do you want to discuss hobbies or interests? (yes/no)");
            hobbyResponse = scanner.nextLine().toLowerCase();

            if (hobbyResponse.equals("yes")) {
                pause();
                System.out.println("CHATBOT: What hobbies or activities do you enjoy?");
                scanner.nextLine();
                pause();
                System.out.println("CHATBOT: That sounds fun! It's always great to have activities that bring joy.");
            } else if (hobbyResponse.equals("no")) {
                pause();
                System.out.println("CHATBOT: No worries! We can talk about anything you like!");
            } else {
                System.out.println("CHATBOT: I didn't understand that. Please answer with 'yes' or 'no'.");
            }
        } while (!hobbyResponse.equals("yes") && !hobbyResponse.equals("no"));

        waitForKeyPress(scanner);
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
        waitForKeyPress(scanner);
    }

    // Method to tell a random joke
    private static void tellJoke() {
        String[] jokes = {
            "CHATBOT: Why do Java developers wear glasses? Because they don’t see sharp!",
            "CHATBOT: What did one ocean say to the other ocean? Nothing, they just waved!",
            "CHATBOT: Why was the math book sad? It had too many problems.",
            "CHATBOT: Why do programmers prefer dark mode? Because light attracts bugs!",
            "CHATBOT: Why was the JavaScript developer sad? Because he didn’t 'null' his feelings properly.",
            "CHATBOT: What’s a programmer’s favorite type of music? Algo-rhythm!"
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
        while (true) {
            System.out.println("CHATBOT: What would you like to calculate?");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.print("Your choice: ");
            
            String choice = scanner.nextLine();
            
            if (!choice.matches("[1-4]")) {
                System.out.println("CHATBOT: I didn't understand that. Please choose an option from the menu.");
                continue;
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
            waitForKeyPress(scanner);
            return;
        }
    }

    // Method to introduce a short pause before the next interaction
    private static void pause() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Method to wait for user key press before continuing
    private static void waitForKeyPress(Scanner scanner) {
        System.out.println("Press ENTER to continue...");
        scanner.nextLine();
    }
}
