package studentgradecalculator;
import java.util.Scanner;

public class StudentGradeCalculater {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask how many grades to enter
        System.out.print("Enter the number of grades: ");
        int n = scanner.nextInt();

        // Create array to store grades
        float[] grades = new float[n];
        float sum = 0;

        // Input each grade using a loop
        for (int i = 0; i < n; i++) {
            System.out.print("Enter grade " + (i + 1) + ": ");
            grades[i] = scanner.nextFloat();
            sum += grades[i]; // Add to sum
        }

        // Calculate average
        double average = sum / n;

        // Display result
        System.out.println("Average grade = " + average);

        scanner.close();
    }
}
