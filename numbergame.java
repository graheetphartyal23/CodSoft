import java.util.Random;
import java.util.Scanner;

public class numbergame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        int roundsPlayed = 0;
        int roundsWon = 0;
        String playAgain = "y";

        System.out.println("Welcome to the Guessing Game!");

        // Main game loop
        while (playAgain.equalsIgnoreCase("y")) {
            int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            roundsPlayed++;

            System.out.println("\nRound " + roundsPlayed + ": Guess the number between " + lowerBound + " and " + upperBound + "!");

            // Guessing loop
            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + ": Enter your guess: ");

                // Handle invalid inputs
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a valid number.");
                    scanner.next(); // Clear the invalid input
                }

                int guess = scanner.nextInt();
                attempts++;

                // Check if the guess is within bounds
                if (guess < lowerBound || guess > upperBound) {
                    System.out.println("Please enter a number between " + lowerBound + " and " + upperBound + ".");
                    continue;
                }

                // Provide feedback on the guess
                if (guess < randomNumber) {
                    System.out.println("Too low!");
                } else if (guess > randomNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the number " + randomNumber + " correctly in " + attempts + " attempts.");
                    roundsWon++;
                    break;
                }
            }

            // If max attempts reached, reveal the number
            if (attempts == maxAttempts) {
                System.out.println("Sorry! You've used all " + maxAttempts + " attempts. The correct number was " + randomNumber + ".");
            }

            // Display score after each round
            System.out.println("Score: Rounds Played - " + roundsPlayed + ", Rounds Won - " + roundsWon);

            // Ask if the user wants to play again
            System.out.print("Do you want to play again? (y/n): ");
            playAgain = scanner.next();
        }

        // Display the final score after the game ends
        System.out.println("\nFinal Score: Rounds Played - " + roundsPlayed + ", Rounds Won - " + roundsWon);
        System.out.println("Thanks for playing!");

        scanner.close();
    }
}