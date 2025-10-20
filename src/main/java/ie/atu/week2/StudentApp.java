package ie.atu.week2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class StudentApp {

    private static final String FILE_NAME = "students.txt";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("How many students do you want to enter? ");
        int numStudents = getValidInt(input);

        // Arrays to hold student data
        String[] names = new String[numStudents];
        String[] emails = new String[numStudents];
        String[] courses = new String[numStudents];

        // Input loop
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("Enter name of student %d: ", i + 1);
            names[i] = input.nextLine().trim();

            System.out.print("Enter email: ");
            emails[i] = input.nextLine().trim();

            System.out.print("Enter course: ");
            courses[i] = input.nextLine().trim();
        }

        // Display results
        System.out.println("\nStudent List:");
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("Name: %s, Email: %s, Course: %s%n", names[i], emails[i], courses[i]);
        }

        // Save to file
        saveToFile(names, emails, courses);

        System.out.println("\nStudent details saved to " + FILE_NAME);
        input.close();
    }

    // 🔹 Helper: Validate integer input
    private static int getValidInt(Scanner input) {
        while (true) {
            try {
                return Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Try again: ");
            }
        }
    }

    // 🔹 Helper: Save all student data to file
    private static void saveToFile(String[] names, String[] emails, String[] courses) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (int i = 0; i < names.length; i++) {
                writer.printf("Name: %s, Email: %s, Course: %s%n", names[i], emails[i], courses[i]);
            }
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }
}
