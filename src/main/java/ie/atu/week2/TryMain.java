package ie.atu.week2;

import java.util.Scanner;

public class TryMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = 0;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.print("Enter a number: ");
                number = Integer.parseInt(input.nextLine());
                valid = true; // success
            } catch (NumberFormatException e) {
                System.out.println("That’s not a valid number. Please try again.");
            }
        }

        System.out.println("You entered: " + number);
        input.close();
    }
}
