import java.util.Scanner;

public class OnlineReservationSystem {

    // Number of seats available for reservation
    private static final int TOTAL_SEATS = 25;
    private boolean[] seats = new boolean[TOTAL_SEATS];

    public static void main(String[] args) {
        OnlineReservationSystem system = new OnlineReservationSystem();
        system.runReservationSystem();
    }

    // Method to run the reservation system
    public void runReservationSystem() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nWelcome to the Online Reservation System");
            System.out.println("1. View Available Seats");
            System.out.println("2. Reserve a Seat");
            System.out.println("3. Cancel a Reservation");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAvailableSeats();
                    break;
                case 2:
                    reserveSeat(scanner);
                    break;
                case 3:
                    cancelReservation(scanner);
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting the system. Thank you!");
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }

        scanner.close();
    }

    // Method to view available seats
    public void viewAvailableSeats() {
        System.out.println("\nAvailable Seats:");
        for (int i = 0; i < TOTAL_SEATS; i++) {
            if (!seats[i]) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
    }

    // Method to reserve a seat
    public void reserveSeat(Scanner scanner) {
        System.out.print("\nEnter seat number to reserve (1-" + TOTAL_SEATS + "): ");
        int seatNumber = scanner.nextInt();

        if (seatNumber < 1 || seatNumber > TOTAL_SEATS) {
            System.out.println("Invalid seat number!");
        } else if (seats[seatNumber - 1]) {
            System.out.println("Seat is already reserved!");
        } else {
            seats[seatNumber - 1] = true;
            System.out.println("Seat " + seatNumber + " has been reserved successfully.");
        }
    }

    // Method to cancel a reservation
    public void cancelReservation(Scanner scanner) {
        System.out.print("\nEnter seat number to cancel (1-" + TOTAL_SEATS + "): ");
        int seatNumber = scanner.nextInt();

        if (seatNumber < 1 || seatNumber > TOTAL_SEATS) {
            System.out.println("Invalid seat number!");
        } else if (!seats[seatNumber - 1]) {
            System.out.println("Seat is not reserved yet!");
        } else {
            seats[seatNumber - 1] = false;
            System.out.println("Reservation for seat " + seatNumber + " has been canceled.");
        }
    }
}