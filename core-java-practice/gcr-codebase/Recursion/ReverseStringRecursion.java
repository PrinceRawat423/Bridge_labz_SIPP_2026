import java.util.Scanner;

public class ReverseStringRecursion {

    static String reverse(String text) {
        if (text.length() <= 1) {
            return text;
        }
        return reverse(text.substring(1)) + text.charAt(0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        System.out.println(reverse(text));
        sc.close();
    }
}
