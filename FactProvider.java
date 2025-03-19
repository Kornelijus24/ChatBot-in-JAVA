import java.util.Random;

public class FactProvider {
    private final Random random = new Random();

    private final String[] facts = {
        "Did you know? Honey never spoils. Archaeologists found 3000-year-old honey in Egyptian tombs!",
        "Did you know? The Eiffel Tower can be 15 cm taller during the summer due to thermal expansion.",
        "Did you know? Octopuses have three hearts and blue blood!",
        "Did you know? The first computer virus was created in 1986 and was called 'Brain'.",
        "Did you know? A day on Venus is longer than a year on Venus!"
    };

    public void tellFact() {
        String fact = facts[random.nextInt(facts.length)];
        ChatUtils.typeWriterEffect(ChatUtils.YELLOW + fact + ChatUtils.RESET, 40);
    }
}