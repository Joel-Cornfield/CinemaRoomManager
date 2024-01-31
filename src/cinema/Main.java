package cinema;
import java.util.Scanner;

import static cinema.Cinema.initializeSeats;

public class Main {
    public static void main(String[] args) {
        // Write your code here
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows: ");
        Cinema.rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row: ");
        Cinema.seats = scanner.nextInt();

        int numSeats = Cinema.rows * Cinema.seats;

        Cinema.initializeSeats();

        int choice;

        do {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            choice = scanner.nextInt();

            System.out.println();

            switch (choice) {
                case 1:
                    Cinema.printSeats();
                    break;
                case 2:
                    Cinema.buyTicket(numSeats);
                    break;
                case 3:
                    System.out.printf("Number of purchased tickets: %d%n", Cinema.count);
                    double percent = ((double) Cinema.count / numSeats) * 100;
                    System.out.printf("Percentage: %.2f%%%n", percent);
                    System.out.printf("Current income: $%d%n", Cinema.income);
                    Cinema.calcTotal(numSeats);
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    System.out.println();

            }
        } while (choice != 0);
        scanner.close();
    }
}