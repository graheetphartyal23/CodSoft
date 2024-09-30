import java.util.Scanner;

public class studentgrade {

    public static void main(String[] args) {
        // Using try-with-resources to automatically close the scanner
        try (Scanner scanner = new Scanner(System.in)) {
            // Ask for the number of subjects
            System.out.print("Enter the number of subjects: ");
            int numberOfSubjects = scanner.nextInt();

            // Array to hold the marks of each subject
            int[] marks = new int[numberOfSubjects];
            int totalMarks = 0;

            // Input marks for each subject
            for (int i = 0; i < numberOfSubjects; i++) {
                System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
                marks[i] = scanner.nextInt();

                // Validate that the marks are within the correct range
                while (marks[i] < 0 || marks[i] > 100) {
                    System.out.print("Invalid input. Please enter marks between 0 and 100: ");
                    marks[i] = scanner.nextInt();
                }

                totalMarks += marks[i];
            }

            // Calculate average percentage
            double averagePercentage = (double) totalMarks / numberOfSubjects;

            // Determine grade based on average percentage
            char grade;
            if (averagePercentage >= 90) {
                grade = 'A';
            } else if (averagePercentage >= 80) {
                grade = 'B';
            } else if (averagePercentage >= 70) {
                grade = 'C';
            } else if (averagePercentage >= 60) {
                grade = 'D';
            } else if (averagePercentage >= 50) {
                grade = 'E';
            } else {
                grade = 'F';
            }

            // Display the results
            System.out.println("\nResults:");
            System.out.println("Total Marks: " + totalMarks);
            System.out.println("Average Percentage: " + averagePercentage + "%");
            System.out.println("Grade: " + grade);
        } // Scanner will automatically close here due to try-with-resources
    }
}