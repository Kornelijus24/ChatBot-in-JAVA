import java.util.Scanner;

public class ChatSession {
    private final Scanner scanner;
    private final User user;
    private final JokeProvider jokeProvider;

    // Constructor - initializes ChatSession with scanner, user, and joke provider
    public ChatSession(Scanner scanner, User user, JokeProvider jokeProvider) {
        this.scanner = scanner;
        this.user = user;
        this.jokeProvider = jokeProvider;
    }

    // Manages user conversation
    public void chatWithUser() {
        System.out.println("CHATBOT: How are you feeling today?");
        String userFeeling = scanner.nextLine().toLowerCase();
        ChatUtils.pause();

        try {
            user.updateMood(userFeeling);
        } catch (Exception e) {
            System.out.println("CHATBOT ERROR: Unable to process mood.");
            return;
        }

        switch (user.getMood()) {
            case "happy":
                System.out.println("CHATBOT: That's great to hear, " + user.getName() + "! What made you happy today?");
                scanner.nextLine();
                ChatUtils.pause();
                
                System.out.println("CHATBOT: That sounds wonderful!");
                ChatUtils.pause();

                askToShareEvent();
                break;

            case "sad":
                ChatUtils.pause();
                askForJoke();
                break;

            default:
                System.out.println("CHATBOT: I see, " + user.getName() + ". Tell me more about it!");
                scanner.nextLine();
                ChatUtils.pause();

                System.out.println("CHATBOT: That is interesting! Thanks for sharing, " + user.getName() + ".");
                ChatUtils.pause();
                break;
        }

        askAboutHobbies();
        ChatUtils.waitForKeyPress(scanner);
    }

    // Asks the user to share a recent exciting event
    private void askToShareEvent() {
        while (true) {
            System.out.println("CHATBOT: Do you want to share any recent exciting events? (yes/no)");
            String response = scanner.nextLine().toLowerCase();
            ChatUtils.pause();

            if (response.equals("yes")) {
                System.out.println("CHATBOT: Awesome! Tell me about it!");
                scanner.nextLine();
                ChatUtils.pause();

                System.out.println("CHATBOT: That sounds amazing! I'm glad you're enjoying yourself!");
                ChatUtils.pause();
                break;
            } else if (response.equals("no")) {
                System.out.println("CHATBOT: No worries! I'm just happy that you're feeling great!");
                ChatUtils.pause();
                break;
            } else {
                System.out.println("CHATBOT: Please answer with 'yes' or 'no'.");
                ChatUtils.pause();
            }
        }
    }

    // Asks the user if they want to hear a joke when they are sad
    private void askForJoke() {
        while (true) {
            System.out.println("CHATBOT: Oh no, " + user.getName() + ". I'm here to cheer you up! Want to hear a joke? (yes/no)");
            String response = scanner.nextLine().toLowerCase();
            ChatUtils.pause();

            if (response.equals("yes")) {
                jokeProvider.tellJoke();
                ChatUtils.pause();
                break;
            } else if (response.equals("no")) {
                System.out.println("CHATBOT: That's okay! If you ever need cheering up, I'm here for you.");
                ChatUtils.pause();
                break;
            } else {
                System.out.println("CHATBOT: Please answer with 'yes' or 'no'.");
                ChatUtils.pause();
            }
        }
    }

    // Asks the user about their hobbies or interests
    private void askAboutHobbies() {
        while (true) {
            System.out.println("CHATBOT: Do you want to discuss hobbies or interests? (yes/no)");
            String response = scanner.nextLine().toLowerCase();
            ChatUtils.pause();

            if (response.equals("yes")) {
                System.out.println("CHATBOT: What hobbies or activities do you enjoy?");
                scanner.nextLine();
                ChatUtils.pause();

                System.out.println("CHATBOT: That sounds fun! It's always great to have activities that bring joy.");
                ChatUtils.pause();
                break;
            } else if (response.equals("no")) {
                System.out.println("CHATBOT: No worries! We can talk about anything you like!");
                ChatUtils.pause();
                break;
            } else {
                System.out.println("CHATBOT: Please answer with 'yes' or 'no'.");
                ChatUtils.pause();
            }
        }

        System.out.println("");
        System.out.println("END OF CONVERSATION");
        System.out.println("MORE WILL BE ADDED IN THE FUTURE...");  
    }
}
