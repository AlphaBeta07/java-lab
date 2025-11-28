// ReadFile.java
import java.io.*;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String fname = sc.nextLine();
        try {
            File f = new File(fname);
            if (!f.exists()) {
                System.out.println("File not found. Creating new file.");
                f.createNewFile();
            }
            // Read file
            System.out.println("--- File contents ---");
            FileInputStream fis = new FileInputStream(f);
            int ch;
            while ((ch = fis.read()) != -1) System.out.print((char)ch);
            fis.close();
            System.out.println("\n---------------------");
            System.out.print("Append text? (y/n): ");
            String ans = sc.nextLine();
            if (ans.equalsIgnoreCase("y")) {
                System.out.println("Enter text to append (single line):");
                String line = sc.nextLine();
                FileOutputStream fos = new FileOutputStream(f, true); // append true
                fos.write((line + System.lineSeparator()).getBytes());
                fos.close();
                System.out.println("Appended.");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}
