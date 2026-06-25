import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayAccessExceptionDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter array size (0 for no array): ");
            int size = scanner.nextInt();

            int[] numbers = null;
            if (size > 0) {
                numbers = new int[size];
                for (int i = 0; i < size; i++) {
                    System.out.print("Enter value for index " + i + ": ");
                    numbers[i] = scanner.nextInt();
                }
            }

            System.out.print("Enter index to read: ");
            int index = scanner.nextInt();
            System.out.println("Value at index " + index + ": " + numbers[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        } catch (InputMismatchException e) {
            System.out.println("Please enter only numeric values");
        } finally {
            scanner.close();
        }
    }
}
