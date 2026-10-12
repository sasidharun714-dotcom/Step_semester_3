package string.class_problems;

import java.util.Scanner;

abstract class Seat {
    static final double FEE = 20.0;
    int count;

    Seat(int count) {
        this.count = count;
    }

    abstract double ticketPrice();

    double calculateAmount() {
        return count * (ticketPrice() + FEE);
    }
}

class Regular extends Seat {
    Regular(int count) {
        super(count);
    }

    double ticketPrice() {
        return 150;
    }
}

class Premium extends Seat {
    Premium(int count) {
        super(count);
    }

    double ticketPrice() {
        return 250;
    }
}

class Recliner extends Seat {
    Recliner(int count) {
        super(count);
    }

    double ticketPrice() {
        return 400;
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int count = sc.nextInt();

            Seat seat;

            if (type.equals("REGULAR")) {
                seat = new Regular(count);
            } else if (type.equals("PREMIUM")) {
                seat = new Premium(count);
            } else {
                seat = new Recliner(count);
            }

            double amount = seat.calculateAmount();
            System.out.printf("%s: %.2f%n", type, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}