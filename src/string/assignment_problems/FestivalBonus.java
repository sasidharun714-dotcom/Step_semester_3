package string.class_problems;

import java.util.Scanner;

interface Employee {
    double calculateBonus(double salary);
}

class FullTime implements Employee {
    public double calculateBonus(double salary) {
        return salary * 0.10;
    }
}

class PartTime implements Employee {
    public double calculateBonus(double salary) {
        return salary * 0.05;
    }
}

class Intern implements Employee {
    public double calculateBonus(double salary) {
        return 2000;
    }
}

public class FestivalBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double salary = sc.nextDouble();

            Employee employee;

            if (type.equals("FULLTIME")) {
                employee = new FullTime();
            } else if (type.equals("PARTTIME")) {
                employee = new PartTime();
            } else {
                employee = new Intern();
            }

            double bonus = employee.calculateBonus(salary);

            System.out.printf("%s: %.2f%n", type, bonus);
            total += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", total);

        sc.close();
    }
}