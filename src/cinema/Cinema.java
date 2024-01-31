package cinema;
import java.util.Scanner;

public class Cinema {
    static int total;
    static int rows;
    static int seats;
    static int price;
    static int count;
    static int income;
    static char[][] cinemaSeats;

    static void initializeSeats() {
        cinemaSeats = new char[rows][seats];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                cinemaSeats[i][j] = 'S'; // Initialize all seats as 'S'
            }
        }
    }

    static void printSeats() {
        System.out.println("Cinema:");
        System.out.print(" ");

        for (int i = 1; i <= seats; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < seats; j++) {
                System.out.print(" " + cinemaSeats[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    static boolean validTicket(int rowNum, int seatNum) {
        return rowNum >= 1 && rowNum <= rows && seatNum >= 1 && seatNum <= seats;
    }

    static void buyTicket(int numSeats) {
        Scanner scanner = new Scanner(System.in);

        int rowNum;
        int seatNum;
        boolean purchased;

        do {
            System.out.println("Enter a row number: ");
            rowNum = scanner.nextInt();
            System.out.println("Enter a seat number in that row: ");
            seatNum = scanner.nextInt();

            purchased = false;

            if (!validTicket(rowNum, seatNum)) {
                System.out.println();
                System.out.println("Wrong input");
                System.out.println();
                continue;
            }

            if (cinemaSeats[rowNum - 1][seatNum - 1] == 'B') {
                purchased = true;
                System.out.println();
                System.out.println("That ticket has already been purchased!");
                System.out.println();
            } else {
                calcPrice(numSeats, rowNum);
                cinemaSeats[rowNum - 1][seatNum - 1] = 'B'; // Mark seat as taken
                count++;
                income += price;
            }

        } while (!validTicket(rowNum, seatNum) || purchased);
    }

    static void calcPrice(int numSeats, int rowNum) {
        if (numSeats > 60) {
            int half = rows / 2;
            if (rowNum <= half) {
                price = 10;
            } else {
                price = 8;
            }
        } else {
            price = 10;
        }
        System.out.printf("Ticket price: $%d%n", price);
        System.out.println();
    }

    static void calcTotal(int numSeats) {
        if (numSeats > 60) {
            int half = rows / 2;
            total = (half * seats * 10) + ((rows - half) * seats * 8);
        } else {
            total = (numSeats * 10);
        }
        System.out.printf("Total income: $%d%n", total);
    }
}

