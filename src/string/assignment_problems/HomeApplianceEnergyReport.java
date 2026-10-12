package string.class_problems;

import java.util.Scanner;

abstract class Appliance {
    double power;

    Appliance(double power) {
        this.power = power;
    }

    abstract boolean supportsSaver();

    double calculateUnits(double hours, boolean saver) {
        double units = power * hours / 1000.0;

        if (saver) {
            units = units * 0.75;
        }

        return units;
    }

    double calculateCost(double units) {
        return units * 8;
    }
}

class Fridge extends Appliance {
    Fridge() {
        super(150);
    }

    boolean supportsSaver() {
        return false;
    }
}

class AC extends Appliance {
    AC() {
        super(1500);
    }

    boolean supportsSaver() {
        return true;
    }
}

class TV extends Appliance {
    TV() {
        super(100);
    }

    boolean supportsSaver() {
        return false;
    }
}

class Washer extends Appliance {
    Washer() {
        super(500);
    }

    boolean supportsSaver() {
        return true;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();

            boolean saver = false;

            if (sc.hasNext()) {
                sc.nextLine(); // consume remaining line
                // Saver is checked from the input line below.
            }
        }

        sc.close();
    }
}