interface CouponValidator {
    boolean validateCoupon(String code);

    static boolean isLengthValid(String code) {
        return code != null && code.length() == 8;
    }
}

class ShoppingCart implements CouponValidator {
    private String[] coupons;

    public ShoppingCart(String[] coupons) {
        this.coupons = coupons;
    }

    @Override
    public boolean validateCoupon(String code) {
        if (!CouponValidator.isLengthValid(code)) {
            return false;
        }
        return code.startsWith("SAVE") || code.startsWith("DISC");
    }

    public void validateAll() {
        for (String code : coupons) {
            System.out.println(code + ": " + (validateCoupon(code) ? "VALID" : "INVALID"));
        }
    }

    public static void main(String[] args) {
        String[] codes = {"SAVE2026", "DISC1234", "BADCODE", "SAVE123", "DISC0000"};
        ShoppingCart cart = new ShoppingCart(codes);
        cart.validateAll();
    }
}
