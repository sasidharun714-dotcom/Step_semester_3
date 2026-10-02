package string.class_problems;

import java.time.LocalDate;

interface LibraryItem {
    LocalDate calculateDueDate(LocalDate currentDate);
}

class Book implements LibraryItem {

    @Override
    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(14);
    }
}

class DVD implements LibraryItem {

    @Override
    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(7);
    }
}

class Magazine implements LibraryItem {

    @Override
    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(3);
    }
}

public class LibraryItemDueDate {

    public static void main(String[] args) {

        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        LibraryItem book = new Book();
        LibraryItem dvd = new DVD();
        LibraryItem magazine = new Magazine();

        System.out.println("1984: " +
                book.calculateDueDate(currentDate));

        System.out.println("The Matrix: " +
                dvd.calculateDueDate(currentDate));

        System.out.println("Forbes Issue 500: " +
                magazine.calculateDueDate(currentDate));
    }
}