package passwordchecker;
import java.util.Scanner;

public class PasswordChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else hasSpecial = true;
        }

        if (password.length() < 8) {
            System.out.println(" Password too short! Use at least 8 characters.");
        } else if (hasUpper && hasLower && hasDigit && hasSpecial) {
            System.out.println(" Strong password!");
        } else {
            if (!hasUpper) System.out.println("- An uppercase letter");
            if (!hasLower) System.out.println("- A lowercase letter");
            if (!hasDigit) System.out.println("- A number");
            if (!hasSpecial) System.out.println("- A special character (like @, #, !)");
        }
    }
}
