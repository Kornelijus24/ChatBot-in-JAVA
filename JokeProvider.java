import java.util.Random;

public class JokeProvider {
    private final Random random = new Random();

    private final String[] jokes = {
        "Why do Java developers wear glasses? Because they don’t see sharp!",
        "What did one ocean say to the other ocean? Nothing, they just waved!",
        "Why was the math book sad? It had too many problems.",
        "Why do programmers prefer dark mode? Because light attracts bugs!",
        "Why was the JavaScript developer sad? Because he didn’t 'null' his feelings properly.",
        "What’s a programmer’s favorite type of music? Algo-rhythm!"
    };

    public void tellJoke() {
        String joke = jokes[random.nextInt(jokes.length)];
        ChatUtils.typeWriterEffect(ChatUtils.YELLOW + joke + ChatUtils.RESET, 40);
    }
}
