import java.util.Scanner;

public class StringSubstringCharAt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();
        System.out.print("Enter start index: ");
        int start = sc.nextInt();
        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        if (start < 0 || end > text.length() || start > end) {
            System.out.println("Invalid indexes. Start must be >= 0, end must be <= text length, and start must be <= end.");
            sc.close();
            return;
        }

        String charAtSubstring = createSubstringUsingCharAt(text, start, end);
        String builtInSubstring = text.substring(start, end);

        System.out.println("Substring using charAt(): " + charAtSubstring);
        System.out.println("Substring using substring(): " + builtInSubstring);
        System.out.println("Both results are same: " + charAtSubstring.equals(builtInSubstring));

        sc.close();
    }

    private static String createSubstringUsingCharAt(String text, int start, int end) {
        StringBuilder result = new StringBuilder();

        for (int i = start; i < end; i++) {
            result.append(text.charAt(i));
        }

        return result.toString();
    }
}
