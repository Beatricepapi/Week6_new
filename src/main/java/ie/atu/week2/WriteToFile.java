package ie.atu.week2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WriteToFile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a student name: ");
        String name = input.nextLine();

        try (PrintWriter writer = new PrintWriter(new FileWriter("students.txt", true))) {
            writer.println(name);
            System.out.println("Name saved to students.txt");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        input.close();
    }
}
