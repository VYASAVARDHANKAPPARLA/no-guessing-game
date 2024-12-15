import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    static int score = 0;
    static int maxAttempts = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain;

        do {
            playAgain = playRound(random, scanner);
            if (playAgain) {
                System.out.println("Next round...");
            }
        } while (playAgain);

        System.out.println("Game Over! Your final score: " + score);
    }

    public static boolean playRound(Random random, Scanner scanner) {
        int attempts = 0;
        int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
        int guess;
        boolean isGuessedCorrectly = false;

        System.out.println("New Round! Guess the number between 1 and 100. You have " + maxAttempts + " attempts.");

        while (attempts < maxAttempts) {
            System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess < numberToGuess) {
                System.out.println("Your guess is too low!");
            } else if (guess > numberToGuess) {
                System.out.println("Your guess is too high!");
            } else {
                isGuessedCorrectly = true;
                break;
            }
        }

        if (isGuessedCorrectly) {
            System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
            score += (maxAttempts - attempts + 1); // Scoring based on remaining attempts
        } else {
            System.out.println("Sorry! You've used all " + maxAttempts + " attempts. The correct number was " + numberToGuess + ".");
        }

        System.out.print("Do you want to play another round? (yes/no): ");
        String response = scanner.next();
        return response.equalsIgnoreCase("yes");
    }
}
