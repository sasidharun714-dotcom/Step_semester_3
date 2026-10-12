import java.util.Scanner;

abstract class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateFee();

    double busFee() {
        return 12000;
    }
}

class DayScholar extends Student {
    DayScholar(String name) {
        super(name);
    }

    double calculateFee() {
        return 40000 + busFee();
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double calculateFee() {
        return 40000 + 60000;
    }
}

class Scholar extends Student {
    Scholar(String name) {
        super(name);
    }

    double calculateFee() {
        return 20000 + busFee();
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            Student s;

            if (type.equals("DAY_SCHOLAR"))
                s = new DayScholar(name);
            else if (type.equals("HOSTELLER"))
                s = new Hosteller(name);
            else
                s = new Scholar(name);

            double fee = s.calculateFee();

            System.out.printf("%s: %.2f%n", name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}