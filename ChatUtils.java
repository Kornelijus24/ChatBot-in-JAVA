import java.util.Scanner;

 public class ChatUtils {
 
    // Method to introduce a short pause before the next interaction
    public static void pause() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("CHATBOT ERROR: Unable to pause execution.");
        }
     }
 
    // Method to wait for user key press before continuing
     public static void waitForKeyPress(Scanner scanner) {
        System.out.println("Press ENTER to continue...");
        scanner.nextLine();
     }
 }
 