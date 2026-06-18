import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.next();

        System.out.println("This will show the exception:");

        System.out.println("This will handle the exception:");
        handleStringIndexOutOfBoundsException(text);

        sc.close();
    }

    private static void generateStringIndexOutOfBoundsException(String text) {
        System.out.println(text.charAt(text.length()));
    }

    private static void handleStringIndexOutOfBoundsException(String text) {
        try {
            System.out.println(text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException caught: " + e.getMessage());
        }
    }
}
