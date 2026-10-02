package string.class_problems;

import java.util.Scanner;

interface Transport {
    double calculateFare(double distance);
}

class Bus implements Transport {

    public double calculateFare(double distance) {
        return 10 + (2 * distance);
    }
}

class Train implements Transport {

    public double calculateFare(double distance) {
        return 20 + (1.5 * distance);
    }
}

class Metro implements Transport {

    public double calculateFare(double distance) {
        return 15 + (2.5 * distance);
    }
}

public class PublicTransportFare {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double distance = sc.nextDouble();

            Transport transport;

            if (type.equals("BUS")) {
                transport = new Bus();
            } else if (type.equals("TRAIN")) {
                transport = new Train();
            } else {
                transport = new Metro();
            }

            double fare = transport.calculateFare(distance);

            System.out.printf("%s: %.2f%n", type, fare);

            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}