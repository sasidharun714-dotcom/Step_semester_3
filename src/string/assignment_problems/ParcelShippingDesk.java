package string.class_problems;

import java.util.Scanner;

abstract class Parcel {
    double weight;
    double declaredValue;

    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract double shippingCharge();

    double insurance() {
        return 0;
    }

    double total() {
        return shippingCharge() + insurance();
    }
}

class StandardParcel extends Parcel {
    StandardParcel(double weight, double value) {
        super(weight, value);
    }

    double shippingCharge() {
        return 40 + 10 * weight;
    }
}

class ExpressParcel extends Parcel {
    ExpressParcel(double weight, double value) {
        super(weight, value);
    }

    double shippingCharge() {
        return 80 + 15 * weight;
    }

    double insurance() {
        return declaredValue * 0.02;
    }
}

class FragileParcel extends Parcel {
    FragileParcel(double weight, double value) {
        super(weight, value);
    }

    double shippingCharge() {
        return 40 + 10 * weight + 50;
    }

    double insurance() {
        return declaredValue * 0.02;
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

            Parcel parcel;

            if (type.equals("STANDARD")) {
                parcel = new StandardParcel(weight, value);
            } else if (type.equals("EXPRESS")) {
                parcel = new ExpressParcel(weight, value);
            } else {
                parcel = new FragileParcel(weight, value);
            }

            double charge = parcel.shippingCharge();
            double insurance = parcel.insurance();
            double total = parcel.total();

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