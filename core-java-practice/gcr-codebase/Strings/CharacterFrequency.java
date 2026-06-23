import java.util.Scanner;

public class CharacterFrequency {

    public static String[] findFrequency(String text) {

        char[] chars = text.toCharArray();
        int length = chars.length;

        int[] frequency = new int[length];

        for (int i = 0; i < length; i++) {
            frequency[i] = 1;
        }

        for (int i = 0; i < length; i++) {

            if (chars[i] == '0') {
                continue;
            }

            for (int j = i + 1; j < length; j++) {

                if (chars[i] == chars[j]) {
                    frequency[i]++;
                    chars[j] = '0'; 
                }
            }
        }

        int count = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i] != '0') {
                count++;
            }
        }

        // Step 4: Store result in String array
        String[] result = new String[count];
        int index = 0;

        for (int i = 0; i < length; i++) {
            if (chars[i] != '0') {
                result[index] = chars[i] + " : " + frequency[i];
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String[] result = findFrequency(text);

        System.out.println("Character Frequencies:");

        for (String s : result) {
            System.out.println(s);
        }

        sc.close();
    }
}
