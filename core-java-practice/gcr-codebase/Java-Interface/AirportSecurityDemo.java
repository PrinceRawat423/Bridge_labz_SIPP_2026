public class AirportSecurityDemo {
    interface LuggageScanner {
        boolean scanLuggage(String luggageType);

        default void displaySecurityGuidelines() {
            System.out.println("Luggage guideline: no prohibited items allowed.");
        }
    }

    interface PassportVerifier {
        boolean verifyPassport(String passportNo);

        default void displaySecurityGuidelines() {
            System.out.println("Passport guideline: verify format and expiry.");
        }
    }

    static class AirportSecuritySystem implements LuggageScanner, PassportVerifier {
        private final String[] passengerNames;
        private final String[] passportNumbers;
        private final String[] luggageTypes;

        AirportSecuritySystem(String[] passengerNames, String[] passportNumbers, String[] luggageTypes) {
            this.passengerNames = passengerNames;
            this.passportNumbers = passportNumbers;
            this.luggageTypes = luggageTypes;
        }

        @Override
        public boolean scanLuggage(String luggageType) {
            return !"prohibited".equalsIgnoreCase(luggageType);
        }

        @Override
        public boolean verifyPassport(String passportNo) {
            return isPassportNumberValid(passportNo);
        }

        @Override
        public void displaySecurityGuidelines() {
            LuggageScanner.super.displaySecurityGuidelines();
            PassportVerifier.super.displaySecurityGuidelines();
        }

        static boolean isPassportNumberValid(String passportNo) {
            return passportNo != null && passportNo.matches("[A-Z]{2}\\d{6}");
        }

        void evaluateBoarding() {
            displaySecurityGuidelines();
            for (int i = 0; i < passengerNames.length; i++) {
                boolean passportOk = verifyPassport(passportNumbers[i]);
                boolean luggageOk = scanLuggage(luggageTypes[i]);
                boolean canBoard = passportOk && luggageOk;
                System.out.println(passengerNames[i] + " -> " + (canBoard ? "Allowed to board" : "Boarding denied"));
            }
        }
    }

    public static void main(String[] args) {
        String[] names = {"Amit", "Sara", "Ravi"};
        String[] passports = {"AB123456", "XY654321", "ZZ123"};
        String[] luggage = {"bag", "prohibited", "carry-on"};

        AirportSecuritySystem system = new AirportSecuritySystem(names, passports, luggage);
        system.evaluateBoarding();
    }
}
