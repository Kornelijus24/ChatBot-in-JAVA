import java.util.Random;
import java.util.Scanner;

public class Game {
    private final Scanner scanner;
    private final Random random = new Random();

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    public void play() {
        int numberToGuess = random.nextInt(10) + 1;
        int attempts = 3;

        while (attempts > 0) {
            System.out.print("CHATBOT: Guess the number (1-10): ");
            int guess = scanner.nextInt();
            scanner.nextLine();

            if (guess == numberToGuess) {
                System.out.println("CHATBOT: Correct!");
                return;
            } else {
                System.out.println("CHATBOT: Try again! Attempts left: " + (--attempts));
            }
        }
        System.out.println("CHATBOT: The correct number was " + numberToGuess);
    }
}

