interface LuggageScanner {
    boolean scanLuggage(String passengerName, String luggageTag);

    default void displaySecurityGuidelines() {
        System.out.println("LuggageScanner guidelines: Keep liquids under 100ml and remove electronics.");
    }

    static boolean isPassportNumberValid(String passportNo) {
        return passportNo != null && passportNo.matches("[A-Z0-9]{8,9}");
    }
}

interface PassportVerifier {
    boolean verifyPassport(String passportNo);

    default void displaySecurityGuidelines() {
        System.out.println("PassportVerifier guidelines: Passport must be valid and readable.");
    }
}

class AirportSecuritySystem implements LuggageScanner, PassportVerifier {
    @Override
    public boolean scanLuggage(String passengerName, String luggageTag) {
        return luggageTag != null && !luggageTag.isBlank();
    }

    @Override
    public boolean verifyPassport(String passportNo) {
        return LuggageScanner.isPassportNumberValid(passportNo);
    }

    @Override
    public void displaySecurityGuidelines() {
        LuggageScanner.super.displaySecurityGuidelines();
        PassportVerifier.super.displaySecurityGuidelines();
    }

    public void processPassengers(String[] names, String[] passports, String[] luggageTags) {
        for (int i = 0; i < names.length; i++) {
            boolean passportOk = verifyPassport(passports[i]);
            boolean luggageOk = scanLuggage(names[i], luggageTags[i]);
            System.out.println(names[i] + ": " + (passportOk && luggageOk ? "CAN BOARD" : "CANNOT BOARD"));
        }
    }

    public static void main(String[] args) {
        String[] names = {"Amit", "Priya", "Ravi"};
        String[] passports = {"A1234567", "INVALID", "B98765432"};
        String[] luggageTags = {"LUGG123", "", "TAG456"};
        AirportSecuritySystem system = new AirportSecuritySystem();
        system.displaySecurityGuidelines();
        system.processPassengers(names, passports, luggageTags);
    }
}
