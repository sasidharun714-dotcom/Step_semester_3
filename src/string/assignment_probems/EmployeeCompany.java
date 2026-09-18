package string.assignment_probems;

public class EmployeeCompany {

    String name;
    int id;

    static String companyName = "ABC Technologies";

    EmployeeCompany(String name, int id) {
        this.name = name;
        this.id = id;
    }

    static void printCompanyName() {
        System.out.println("Company: " + companyName);
    }

    void printEmployee() {
        System.out.println("ID: " + id + " | Name: " + name);
    }

    public static void main(String[] args) {

        EmployeeCompany e1 = new EmployeeCompany("Arun", 101);
        EmployeeCompany e2 = new EmployeeCompany("Priya", 102);

        EmployeeCompany.printCompanyName();

        e1.printEmployee();
        e2.printEmployee();
    }
}