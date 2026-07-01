public class CouponValidatorDemo {
    interface CouponValidator {
        boolean validateCoupon(String code);

        static boolean isLengthValid(String code) {
            return code != null && code.length() >= 6 && code.length() <= 12;
        }
    }

    static class ShoppingCart implements CouponValidator {
        private final String[] coupons;

        ShoppingCart(String[] coupons) {
            this.coupons = coupons;
        }

        @Override
        public boolean validateCoupon(String code) {
            if (code == null) {
                return false;
            }
            return CouponValidator.isLengthValid(code)
                    && (code.startsWith("SAVE") && (code.contains("10") || code.contains("20")));
        }

        void validateAllCoupons() {
            System.out.println("Coupon Validation Results:");
            for (String coupon : coupons) {
                boolean valid = validateCoupon(coupon);
                System.out.println(coupon + " -> " + (valid ? "Valid" : "Invalid"));
            }
        }
    }

    public static void main(String[] args) {
        String[] coupons = {"SAVE10", "WELCOME20", "DISCOUNT", "SAVE5", null};
        ShoppingCart cart = new ShoppingCart(coupons);
        cart.validateAllCoupons();
    }
}
