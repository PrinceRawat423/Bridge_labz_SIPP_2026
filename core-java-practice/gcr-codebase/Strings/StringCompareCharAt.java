import java.util.Scanner;

public class StringCompareCharAt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String first = sc.next();
        System.out.print("Enter second string: ");
        String second = sc.next();

        boolean charAtResult = compareUsingCharAt(first, second);
        boolean builtInResult = first.equals(second);

        System.out.println("Result using charAt(): " + charAtResult);
        System.out.println("Result using equals(): " + builtInResult);
        System.out.println("Both results are same: " + (charAtResult == builtInResult));

        sc.close();
    }

    private static boolean compareUsingCharAt(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }

        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
