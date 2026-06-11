/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehicle.management.system;

import java.util.Scanner;

/**
 *
 * @author andries
 */
public class Input {

    private static Scanner scanner = new Scanner(System.in);

    // Read String
    public static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    // Read Integer
    public static int readInt(String prompt) {

        while (true) {
            try {

                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {

                System.out.println("\n❌ INVALID INPUT. Please enter a whole number");

            }
        }
    }

    // Read Double
    public static double readDouble(String prompt) {

        while (true) {
            try {

                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine());

            } catch (NumberFormatException e) {

                System.out.println("\n❌ INVALID INPUT. Please enter a decimal number");
            }
        }

    }

    // Read Positive Integer
    public static int readPositiveInt(String prompt) {

        while (true) {
            int num = readInt(prompt);

            if (num > 0) {
                return num;
            } else {
                System.out.println("\n❌ INVALID INPUT. Please enter a whole number greater than 0");
            }

        }
    }

    // Read Positive Double
    public static double readPositiveDouble(String prompt) {

        while (true) {
            double num = readDouble(prompt);

            if (num > 0) {
                return num;
            } else {
                System.out.println("\n❌ INVALID INPUT. Please enter a decimal number greater than 0");
            }
        }
    }

    // Read Integer in Rage
    public static int readIntInRange(String prompt, int min, int max) {

        while (true) {
            int num = readInt(prompt);

            if (num >= min && num <= max) {
                return num;
            } else {
                System.out.print("\n❌ INVALID INPUT. Please enter a whole number between " + min + " and " + max);
            }
        }

    }
}
