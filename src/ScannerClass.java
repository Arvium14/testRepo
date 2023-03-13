public class ScannerClass {

    public static String readString() {
        java.util.Scanner in = new java.util.Scanner(System.in);
        return in.nextLine().toLowerCase();
    }
    public static int readNumber() {
        java.util.Scanner in = new java.util.Scanner(System.in);
        int myInt = in.nextInt();
        in.nextLine();
        return myInt;
    }
}
