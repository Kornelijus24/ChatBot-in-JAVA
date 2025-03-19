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

        ChatUtils.typeWriterEffect(ChatUtils.BLUE + "I have chosen a number between 1 and 10. Try to guess it!" + ChatUtils.RESET, 40);

        while (attempts > 0) {
            System.out.print(ChatUtils.BLUE + "Guess the number (1-10): " + ChatUtils.RESET);
            int guess = scanner.nextInt();
            scanner.nextLine();

            if (guess == numberToGuess) {
                ChatUtils.typeWriterEffect(ChatUtils.GREEN + "Correct! You guessed it right!" + ChatUtils.RESET, 40);
                return;
            } else {
                ChatUtils.typeWriterEffect(ChatUtils.YELLOW + "Try again! Attempts left: " + (--attempts) + ChatUtils.RESET, 40);
            }
        }
        ChatUtils.typeWriterEffect(ChatUtils.RED + "You lose! The correct number was " + numberToGuess + "." + ChatUtils.RESET, 40);
    }
}
