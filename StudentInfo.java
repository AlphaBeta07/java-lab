// StudentInfo.java
import java.io.*;
import java.util.Scanner;

public class StudentInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file name to store student records: ");
        String fname = sc.nextLine();
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fname, true))) {
            System.out.print("Roll No: "); int roll = Integer.parseInt(sc.nextLine());
            System.out.print("Class: "); String cls = sc.nextLine();
            System.out.print("Age: "); int age = Integer.parseInt(sc.nextLine());
            System.out.print("Weight: "); float weight = Float.parseFloat(sc.nextLine());
            System.out.print("Height: "); float height = Float.parseFloat(sc.nextLine());
            System.out.print("City: "); String city = sc.nextLine();
            System.out.print("Phone: "); String phone = sc.nextLine();

            // Write as UTF (simple portable way)
            dos.writeInt(roll);
            dos.writeUTF(cls);
            dos.writeInt(age);
            dos.writeFloat(weight);
            dos.writeFloat(height);
            dos.writeUTF(city);
            dos.writeUTF(phone);
            System.out.println("Record saved.");
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }

        // Read back
        System.out.print("Read back file? (y/n): ");
        if (sc.nextLine().equalsIgnoreCase("y")) {
            try (DataInputStream dis = new DataInputStream(new FileInputStream(fname))) {
                while (dis.available() > 0) {
                    int roll = dis.readInt();
                    String cls = dis.readUTF();
                    int age = dis.readInt();
                    float weight = dis.readFloat();
                    float height = dis.readFloat();
                    String city = dis.readUTF();
                    String phone = dis.readUTF();
                    System.out.println("---- Record ----");
                    System.out.println("Roll: " + roll + " Class: " + cls + " Age: " + age);
                    System.out.println("Weight: " + weight + " Height: " + height);
                    System.out.println("City: " + city + " Phone: " + phone);
                }
            } catch (EOFException eof) {
                // done
            } catch (IOException e) {
                System.out.println("Read error: " + e.getMessage());
            }
        }
        sc.close();
    }
}
