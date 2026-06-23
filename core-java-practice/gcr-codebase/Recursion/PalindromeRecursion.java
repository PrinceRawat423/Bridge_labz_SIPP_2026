import java.util.Scanner;

public class PalindromeRecursion {

    static boolean isPalindrome(String text, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }
        return isPalindrome(text, left + 1, right - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        boolean result = isPalindrome(text, 0, text.length() - 1);
        System.out.println(result ? "Palindrome" : "Not Palindrome");
        sc.close();
    }
}
