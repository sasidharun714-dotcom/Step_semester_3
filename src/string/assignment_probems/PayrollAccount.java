package string.assignment_probems;

class PayrollAccount {

    private double basicSalary;
    private double bonus;

    // Constructor
    PayrollAccount(double basicSalary) {

        if (basicSalary < 0) {
            System.out.println("Warning: Basic salary cannot be negative.");
            this.basicSalary = 0;
        } else {
            this.basicSalary = basicSalary;
        }

        bonus = 0;
    }

    // Add bonus
    void creditBonus(double amount) {

        if (amount <= 0) {
            System.out.println("Bonus rejected.");
        } else {
            bonus = bonus + amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    // Deduct tax
    void deductTax(double percent) {

        if (percent < 0 || percent > 100) {
            System.out.println("Invalid tax percentage.");
        } else {
            basicSalary = basicSalary - (basicSalary * percent / 100);
            System.out.println("Tax deducted: " + percent + "%");
        }
    }

    // Read-only access
    double getNetSalary() {
        return basicSalary + bonus;
    }

    public static void main(String[] args) {

        PayrollAccount p = new PayrollAccount(50000);

        p.creditBonus(5000);
        p.deductTax(10);

        System.out.println("Net salary: Rs " + p.getNetSalary());
    }
}