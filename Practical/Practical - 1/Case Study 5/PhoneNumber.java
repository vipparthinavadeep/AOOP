public final class PhoneNumber {

    private final String value;

    private PhoneNumber(String value) {
        this.value = value;
    }

    public static PhoneNumber of(String phone) {

        if (phone == null || phone.isBlank()) {
            throw new IllegalArgumentException("Phone cannot be empty");
        }

        phone = phone.trim();

        String pattern = "^\\+[1-9]\\d{7,14}$";

        if (!phone.matches(pattern)) {
            throw new IllegalArgumentException(
                    "Use international format, e.g. +919876543210"
            );
        }

        return new PhoneNumber(phone);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}