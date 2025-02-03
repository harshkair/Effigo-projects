import java.util.Scanner;
import java.util.Random;

public class Hangman {

    public static String[] words = {
        "ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
        "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
        "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
        "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
        "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
        "python", "rabbit", "ram", "rat", "raven", "rhino", "salmon", "seal",
        "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
        "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
        "wombat", "zebra"
    };

    public static String[] gallows = {
        "+---+\n" +
        "|   |\n" +
        "    |\n" +
        "    |\n" +
        "    |\n" +
        "    |\n" +
        "=========\n",

        "+---+\n" +
        "|   |\n" +
        "O   |\n" +
        "    |\n" +
        "    |\n" +
        "    |\n" +
        "=========\n",

        "+---+\n" +
        "|   |\n" +
        "O   |\n" +
        "|   |\n" +
        "    |\n" +
        "    |\n" +
        "=========\n",

        " +---+\n" +
        " |   |\n" +
        " O   |\n" +
        "/|   |\n" +
        "     |\n" +
        "     |\n" +
        " =========\n",

        " +---+\n" +
        " |   |\n" +
        " O   |\n" +
        "/|\\  |\n" +
        "     |\n" +
        "     |\n" +
        " =========\n",

        " +---+\n" +
        " |   |\n" +
        " O   |\n" +
        "/|\\  |\n" +
        "/    |\n" +
        "     |\n" +
        " =========\n",

        " +---+\n" +
        " |   |\n" +
        " O   |\n" +
        "/|\\  |\n" + 
        "/ \\  |\n" +
        "     |\n" +
        " =========\n"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Select a random word from the array
        String wordToGuess = words[random.nextInt(words.length)];
        char[] wordDisplay = new char[wordToGuess.length()];
        for (int i = 0; i < wordToGuess.length(); i++) {
            wordDisplay[i] = '_';
        }

        int incorrectGuesses = 0;
        int maxAttempts = gallows.length - 1;
        StringBuilder guessedLetters = new StringBuilder(); // Using StringBuilder for efficiency

        System.out.println("Welcome to Hangman!");
        
        // Main game loop
        while (incorrectGuesses < maxAttempts) {
            System.out.println(gallows[incorrectGuesses]);
            System.out.println("Word: " + new String(wordDisplay));
            System.out.println("Incorrect guesses: " + guessedLetters);
            System.out.print("Enter a letter: ");
            String input = scanner.nextLine().toLowerCase();

            // Check if the input is valid
            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Please enter a single letter.");
                continue;
            }

            char guessedLetter = input.charAt(0);

            // If the letter has already been guessed
            if (guessedLetters.indexOf(String.valueOf(guessedLetter)) != -1) {
                System.out.println("You've already guessed that letter.");
                continue;
            }

            // Check if the guessed letter is in the word
            boolean correctGuess = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guessedLetter) {
                    wordDisplay[i] = guessedLetter;
                    correctGuess = true;
                }
            }

            // If the guess was incorrect, increment the number of incorrect guesses
            if (!correctGuess) {
                incorrectGuesses++;
                guessedLetters.append(guessedLetter); // Add to guessed letters only if incorrect
            }

            // Check if the player has won
            if (new String(wordDisplay).equals(wordToGuess)) {
                System.out.println("Congratulations! You guessed the word: " + wordToGuess);
                break;
            }
        }

        // If the player has lost
        if (incorrectGuesses == maxAttempts) {
            System.out.println(gallows[incorrectGuesses]);
            System.out.println("Game over! The word was: " + wordToGuess);
        }

        scanner.close();
    }
}
