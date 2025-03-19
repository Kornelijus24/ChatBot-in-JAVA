import java.util.Scanner;

public class ChatSession {
    private final Scanner scanner;
    private final User user;
    private final JokeProvider jokeProvider;

    // Constructor
    public ChatSession(Scanner scanner, User user, JokeProvider jokeProvider) {
        this.scanner = scanner;
        this.user = user;
        this.jokeProvider = jokeProvider;
    }

    // Manages user conversation
    public void chatWithUser() {
        ChatUtils.typeWriterEffect("How are you feeling today?", 40);
        String userFeeling = ChatUtils.readAndPrintUserInput(scanner);

        try {
            user.updateMood(userFeeling);
        } catch (Exception e) {
            ChatUtils.printError("CHATBOT ERROR: Unable to process mood.");
            return;
        }

        switch (user.getMood()) {
            case "happy":
                ChatUtils.typeWriterEffect("That's great to hear, " + user.getName() + "! What made you happy today?", 40);
                ChatUtils.readAndPrintUserInput(scanner);
                ChatUtils.typeWriterEffect("That sounds wonderful!", 40);
                askToShareEvent();
                break;

            case "sad":
                askForJoke();
                break;

            default:
                ChatUtils.typeWriterEffect("I see, " + user.getName() + ". Tell me more about it!", 40);
                ChatUtils.readAndPrintUserInput(scanner);
                ChatUtils.typeWriterEffect("That is interesting! Thanks for sharing, " + user.getName() + ".", 40);
                break;
        }

        askAboutHobbies();
        ChatUtils.waitForKeyPress(scanner);
    }

    // Asks the user to share a recent exciting event
    private void askToShareEvent() {
        while (true) {
            ChatUtils.typeWriterEffect("Do you want to share any recent exciting events? (yes/no)", 40);
            String response = ChatUtils.readAndPrintUserInput(scanner);

            if (response.equals("yes")) {
                ChatUtils.typeWriterEffect("Awesome! Tell me about it!", 40);
                ChatUtils.readAndPrintUserInput(scanner);
                ChatUtils.typeWriterEffect("That sounds amazing! I'm glad you're enjoying yourself!", 40);
                break;
            } else if (response.equals("no")) {
                ChatUtils.typeWriterEffect("No worries! I'm just happy that you're feeling great!", 40);
                break;
            } else {
                ChatUtils.printWarning("Please answer with 'yes' or 'no'.");
            }
        }
    }

    // Asks the user if they want to hear a joke when they are sad
    private void askForJoke() {
        while (true) {
            ChatUtils.typeWriterEffect("Oh no, " + user.getName() + ". I'm here to cheer you up! Want to hear a joke? (yes/no)", 40);
            String response = ChatUtils.readAndPrintUserInput(scanner);

            if (response.equals("yes")) {
                jokeProvider.tellJoke();
                break;
            } else if (response.equals("no")) {
                ChatUtils.typeWriterEffect("That's okay! If you ever need cheering up, I'm here for you.", 40);
                break;
            } else {
                ChatUtils.printWarning("Please answer with 'yes' or 'no'.");
            }
        }
    }

    // Asks the user about their hobbies or interests
    private void askAboutHobbies() {
        while (true) {
            ChatUtils.typeWriterEffect("Do you want to discuss hobbies or interests? (yes/no)", 40);
            String response = ChatUtils.readAndPrintUserInput(scanner);

            if (response.equals("yes")) {
                ChatUtils.typeWriterEffect("What hobbies or activities do you enjoy?", 40);
                ChatUtils.readAndPrintUserInput(scanner);
                ChatUtils.typeWriterEffect("That sounds fun! It's always great to have activities that bring joy.", 40);
                break;
            } else if (response.equals("no")) {
                ChatUtils.typeWriterEffect("No worries! We can talk about anything you like!", 40);
                break;
            } else {
                ChatUtils.printWarning("Please answer with 'yes' or 'no'.");
            }
        }

        System.out.println();
        System.out.println(ChatUtils.YELLOW + "END OF CONVERSATION" + ChatUtils.RESET);
    }
}
