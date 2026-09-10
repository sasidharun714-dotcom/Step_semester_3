package string.assignment_problems;

public class ProductInventoryCSVParser {

    static void parseInventoryRecord(String csvLine) {

        String[] parts = csvLine.split(",");

        String product = parts[0];
        int quantity = Integer.parseInt(parts[1]);
        double price = Double.parseDouble(parts[2]);

        System.out.println("Product: " + product);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {

        String csvLine = "Laptop,10,55000.50";

        parseInventoryRecord(csvLine);
    }
}
