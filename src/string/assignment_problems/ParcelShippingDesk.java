import java.util.Scanner;

abstract class Parcel {
    double weight, value;

    Parcel(double weight, double value) {
        this.weight = weight;
        this.value = value;
    }

    abstract double calculateCharge();

    double calculateInsurance() {
        return 0;
    }

    double calculateTotal() {
        return calculateCharge() + calculateInsurance();
    }
}

class Standard extends Parcel {
    Standard(double w, double v) {
        super(w, v);
    }

    double calculateCharge() {
        return 40 + 10 * weight;
    }
}

class Express extends Parcel {
    Express(double w, double v) {
        super(w, v);
    }

    double calculateCharge() {
        return 80 + 15 * weight;
    }

    double calculateInsurance() {
        return value * 0.02;
    }
}

class Fragile extends Parcel {
    Fragile(double w, double v) {
        super(w, v);
    }

    double calculateCharge() {
        return 40 + 10 * weight + 50;
    }

    double calculateInsurance() {
        return value * 0.02;
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            Parcel p;

            if (type.equals("STANDARD"))
                p = new Standard(weight, value);
            else if (type.equals("EXPRESS"))
                p = new Express(weight, value);
            else
                p = new Fragile(weight, value);

            double charge = p.calculateCharge();
            double insurance = p.calculateInsurance();
            double total = p.calculateTotal();

            System.out.printf(
                    "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    type, charge, insurance, total
            );

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}