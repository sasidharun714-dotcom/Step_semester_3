import java.util.Scanner;

abstract class Cab {
    double distance;

    Cab(double distance) {
        this.distance = distance;
    }

    abstract double rate();

    boolean hasNightService() {
        return true;
    }

    double calculateFare(String time) {
        double fare = Math.max(distance * rate(), 100);

        if (time.equals("NIGHT"))
            fare = fare * 1.20;

        return fare;
    }
}

class Mini extends Cab {
    Mini(double distance) {
        super(distance);
    }

    double rate() {
        return 10;
    }

    boolean hasNightService() {
        return false;
    }
}

class Sedan extends Cab {
    Sedan(double distance) {
        super(distance);
    }

    double rate() {
        return 14;
    }
}

class SUV extends Cab {
    SUV(double distance) {
        super(distance);
    }

    double rate() {
        return 18;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();
            String time = sc.next();

            Cab cab;

            if (type.equals("MINI"))
                cab = new Mini(distance);
            else if (type.equals("SEDAN"))
                cab = new Sedan(distance);
            else
                cab = new SUV(distance);

            if (time.equals("NIGHT") && !cab.hasNightService()) {
                System.out.println(type + ": night service not available");
            } else {
                double fare = cab.calculateFare(time);
                System.out.printf("%s: %.2f%n", type, fare);
                total += fare;
            }
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}