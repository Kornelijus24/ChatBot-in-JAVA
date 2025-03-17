public class User {
    private String name;
    private String mood = "neutral";

    // Sets user name, throws exception if empty
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("User name cannot be empty.");
        }
        this.name = name;
    }

    // Gets user name
    public String getName() {
        return name;
    }

    // Gets current mood
    public String getMood() {
        return mood;
    }

    // Updates user mood based on input
    public void updateMood(String feeling) {
        if (feeling.contains("happy") || feeling.contains("good")) {
            mood = "happy";
        } else if (feeling.contains("sad") || feeling.contains("bad")) {
            mood = "sad";
        } else {
            mood = "neutral";
        }
    }
}

