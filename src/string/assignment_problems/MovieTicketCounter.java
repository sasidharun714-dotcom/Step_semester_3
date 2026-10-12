import java.util.Scanner;

abstract class Ticket {
    int count;

    Ticket(int count) {
        this.count = count;
    }

    abstract double calculate();

    double bookingFee() {
        return 20;
    }
}

class Regular extends Ticket {
    Regular(int count) {
        super(count);
    }

    double calculate() {
        return count * 150 + bookingFee();
    }
}

class Premium extends Ticket {
    Premium(int count) {
        super(count);
    }

    double calculate() {
        return count * 250 + bookingFee();
    }
}

class Recliner extends Ticket {
    Recliner(int count) {
        super(count);
    }

    double calculate() {
        return count * 400 + bookingFee();
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

            Ticket t;

            if (type.equals("REGULAR"))
                t = new Regular(count);
            else if (type.equals("PREMIUM"))
                t = new Premium(count);
            else
                t = new Recliner(count);

            double amount = t.calculate();
            System.out.printf("%s: %.2f%n", type, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}