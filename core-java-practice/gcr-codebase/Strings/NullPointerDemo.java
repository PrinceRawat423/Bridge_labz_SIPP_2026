public class NullPointerDemo {
    public static void main(String[] args) {
        System.out.println("This will show the exception:");

        System.out.println("This will handle the exception:");
        handleNullPointerException();
    }

    private static void generateNullPointerException() {
        String text = null;
        System.out.println(text.length());
    }

    private static void handleNullPointerException() {
        String text = null;

        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage());
        }
    }
}
