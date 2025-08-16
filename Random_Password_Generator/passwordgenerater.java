package randompasswordgenerator;
import java.util.Random;
import java.util.Scanner;

public class passwordgenerater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        // Ask for password length
        System.out.print("Enter password length: ");
        int length = sc.nextInt();

        // Simple character set (you can modify as needed)
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#$%";

        String password = "";

        // Generate password using loop
        for (int i = 0; i < length; i++) {
            int index = rand.nextInt(chars.length());
            password += chars.charAt(index);
        }

        // Show the password
        System.out.println("Generated Password: " + password);

        sc.close();
    }
}
