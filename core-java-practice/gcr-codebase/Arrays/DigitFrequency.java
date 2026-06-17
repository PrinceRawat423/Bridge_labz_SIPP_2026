import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String number = sc.next();

        int length = number.length();
        int[] digits = new int[length];
        for (int i = 0; i < length; i++) {
            digits[i] = Character.getNumericValue(number.charAt(i));
        }

        int[] frequency = new int[10];
        for (int digit : digits) {
            if (digit >= 0 && digit <= 9) {
                frequency[digit]++;
            }
        }

        System.out.println("\nDigit frequency:");
        for (int i = 0; i < frequency.length; i++) {
            System.out.println(i + " -> " + frequency[i]);
        }
        sc.close();
    }
}
