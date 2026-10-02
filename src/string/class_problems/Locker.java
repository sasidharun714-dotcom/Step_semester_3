package string.class_problems;

public class Locker {

    private String code;
    private final int lockerNumber;

    public Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    public void changeCode(String oldCode, String newCode) {
        if (code.equals(oldCode)) {
            code = newCode;
        }
    }

    public static void main(String[] args) {

        Locker l = new Locker(101, "1234");

        l.changeCode("1234", "5678");
        System.out.println("Code changed successfully.");

        l.changeCode("0000", "9999");
        System.out.println("Wrong old code - code remains unchanged.");
    }
}