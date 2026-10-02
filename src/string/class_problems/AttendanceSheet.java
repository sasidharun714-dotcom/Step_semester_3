package string.class_problems;

public class AttendanceSheet {

    private String[] presentStudents;
    private int count;

    public AttendanceSheet(int maxStudents) {
        presentStudents = new String[maxStudents];
        count = 0;
    }

    public void markPresent(String name) {
        // Check if student is already present
        for (int i = 0; i < count; i++) {
            if (presentStudents[i].equals(name)) {
                return;
            }
        }

        // Add student if not already present
        if (count < presentStudents.length) {
            presentStudents[count] = name;
            count++;
        }
    }

    public int getPresentCount() {
        return count;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present Count: " + sheet.getPresentCount());
        System.out.println("Ben present: " + sheet.isPresent("Ben"));
    }
}
