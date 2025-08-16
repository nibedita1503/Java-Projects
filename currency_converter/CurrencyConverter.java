package currencyconverter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class CurrencyConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // ✅ Step 1: Input
            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Enter base currency (e.g. USD): ");
            String base = scanner.nextLine().toUpperCase();

            System.out.print("Enter target currency (e.g. INR): ");
            String target = scanner.nextLine().toUpperCase();

            // ✅ Step 2: Build API URL with your key
            String apiKey = "42059a7bb7467209c2a49fa8";  // ← replace with your real key
            String urlStr = "https://v6.exchangerate-api.com/v6/" + apiKey +
                    "/pair/" + base + "/" + target + "/" + amount;

            System.out.println("\nDEBUG - API URL: " + urlStr);

            // ✅ Step 3: Connect to API
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // ✅ Step 4: Read response
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder responseStr = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseStr.append(line);
            }
            reader.close();

            // ✅ Step 5: Parse and print result
            JSONObject json = new JSONObject(responseStr.toString());

            if (json.has("conversion_result")) {
                double result = json.getDouble("conversion_result");
                System.out.printf("\n💰 Converted Amount: %.2f %s\n", result, target);
            } else {
                System.out.println("\n❌ Error: 'conversion_result' not found.");
                System.out.println("API Response:\n" + json.toString(2));
            }

        } catch (Exception e) {
            System.out.println("😵 Error: " + e.getMessage());
        }

        scanner.close();
    }
}