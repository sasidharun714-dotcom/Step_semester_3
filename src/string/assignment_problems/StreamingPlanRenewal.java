package string.class_problems;

import java.time.LocalDate;
import java.util.Scanner;

interface StreamingPlan {
    LocalDate calculateRenewalDate(LocalDate startDate);
}

class BasicPlan implements StreamingPlan {
    public LocalDate calculateRenewalDate(LocalDate startDate) {
        return startDate.plusDays(30);
    }
}

class StandardPlan implements StreamingPlan {
    public LocalDate calculateRenewalDate(LocalDate startDate) {
        return startDate.plusDays(90);
    }
}

class PremiumPlan implements StreamingPlan {
    public LocalDate calculateRenewalDate(LocalDate startDate) {
        return startDate.plusDays(365);
    }
}

public class StreamingPlanRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String date = sc.next();

            LocalDate startDate = LocalDate.parse(date);

            StreamingPlan plan;

            if (type.equals("BASIC")) {
                plan = new BasicPlan();
            } else if (type.equals("STANDARD")) {
                plan = new StandardPlan();
            } else {
                plan = new PremiumPlan();
            }

            LocalDate renewalDate = plan.calculateRenewalDate(startDate);

            System.out.println(type + ": " + renewalDate);
        }

        sc.close();
    }
}