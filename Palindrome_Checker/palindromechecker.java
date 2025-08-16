package palindromechecker;
import java.util.Scanner;

public class palindromechecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input
        System.out.print("Enter a word: ");
        String s = sc.nextLine();

        // Make everything lowercase
        s = s.toLowerCase();

        // Remove spaces
        s = s.replace(" ", "");

        // Reverse the string using loop
        String reverse = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reverse = reverse + s.charAt(i);
        }

        // Check if original and reverse are same
        if (s.equals(reverse)) {
            System.out.println("It's a palindrome!");
        } else {
            System.out.println("It's not a palindrome.");
        }

        sc.close();
    }
}
