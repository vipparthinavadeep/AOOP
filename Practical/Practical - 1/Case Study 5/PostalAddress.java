public final class PostalAddress {

    private final String street;
    private final String city;
    private final String postalCode;
    private final String country;

    private PostalAddress(
            String street,
            String city,
            String postalCode,
            String country) {

        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public static PostalAddress of(
            String street,
            String city,
            String postalCode,
            String country) {

        if (street == null || street.isBlank())
            throw new IllegalArgumentException("Street is required");

        if (city == null || city.isBlank())
            throw new IllegalArgumentException("City is required");

        if (postalCode == null || postalCode.isBlank())
            throw new IllegalArgumentException("Postal code is required");

        if (country == null || country.isBlank())
            throw new IllegalArgumentException("Country is required");

        return new PostalAddress(
                street.trim(),
                city.trim(),
                postalCode.trim(),
                country.trim()
        );
    }

    @Override
    public String toString() {
        return street + ", " + city + ", " + postalCode + ", " + country;
    }
}