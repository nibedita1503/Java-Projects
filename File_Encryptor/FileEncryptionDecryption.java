import java.io.*;

public class FileEncryptionDecryption {

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Choose any one option: ");
            System.out.println("1. Encrypt");
            System.out.println("2. Decrypt");
            int option = Integer.parseInt(reader.readLine());

            System.out.print("Enter the input file path: ");
            String inputFilePath = reader.readLine();

            System.out.print("Enter the output file path: ");
            String outputFilePath = reader.readLine();

            System.out.print("Enter the encryption key: ");
            int encryptionKey = Integer.parseInt(reader.readLine());

            if(option == 1) {
                encryptFile(inputFilePath, outputFilePath, encryptionKey);
                System.out.println("File encrypted successfully!");
            } else if(option == 2) {
                decryptFile(inputFilePath, outputFilePath, encryptionKey);
                System.out.println("File decrypted successfully!");
            } else {
                System.out.println("Invalid Option!");
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void encryptFile(String inputFilePath, String outputFilePath, int key) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
             String line;
             while ((line = reader.readLine()) != null) {
                 String encryptedLine = encryptString(line, key);
                 writer.write(encryptedLine);
                 writer.newLine();
             }
        }
    }

    private static void decryptFile(String inputFilePath, String outputFilePath, int key) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String decryptedLine = decryptString(line, key);
                writer.write(decryptedLine);
                writer.newLine();
            }
        }
    }

    private static String encryptString(String text, int key) {
    StringBuilder encrypted = new StringBuilder();
    for(int i = 0; i < text.length(); i++) {
        char c = text.charAt(i);
        encrypted.append((char) (c ^ key));
    }

        return encrypted.toString();
    }

    private static String decryptString(String encryptedText, int key) {
        return encryptString(encryptedText, key);
    }
}
