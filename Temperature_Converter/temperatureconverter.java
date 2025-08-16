package temperatureconvertor;
import java.util.Scanner;

public class temperatureconverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter temperature value: ");
        double temperature = sc.nextDouble();

        System.out.print("Enter unit (C for Celsius, F for Fahrenheit): ");
        char unit = sc.next().charAt(0);

        double temp;

        if (unit == 'C') {
            // Celsius to Fahrenheit
            temp = (temperature * 9 / 5) + 32;
            System.out.printf("%.2f°C is %.2f°F\n", temperature, temp);
        } else if (unit == 'F') {
            // Fahrenheit to Celsius
            temp = (temperature - 32) * 5 / 9;
            System.out.printf("%.2f°F is %.2f°C\n", temperature, temp);
        } else {
            System.out.println("Invalid unit! Please enter C or F.");
        }

    }
}
