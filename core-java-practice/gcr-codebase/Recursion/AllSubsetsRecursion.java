import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllSubsetsRecursion {

    static void generateSubsets(int[] arr, int index, String current, List<String> subsets) {
        if (index == arr.length) {
            subsets.add(current);
            return;
        }

        generateSubsets(arr, index + 1, current, subsets);

        String next = current.equals("[]") ? "[" + arr[index] + "]" : current.substring(0, current.length() - 1) + "," + arr[index] + "]";
        generateSubsets(arr, index + 1, next, subsets);
    }

    static void printOrderedSubsets(int[] arr) {
        List<String> subsets = new ArrayList<>();
        generateSubsets(arr, 0, "[]", subsets);
        Collections.sort(subsets, (a, b) -> {
            int sizeA = a.equals("[]") ? 0 : a.split(",").length;
            int sizeB = b.equals("[]") ? 0 : b.split(",").length;
            if (sizeA != sizeB) {
                return Integer.compare(sizeA, sizeB);
            }
            return a.compareTo(b);
        });
        for (String subset : subsets) {
            System.out.println(subset);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        System.out.print("Enter array values: ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        printOrderedSubsets(arr);
        sc.close();
    }
}
