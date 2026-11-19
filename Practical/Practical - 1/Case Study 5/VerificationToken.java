import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

public final class VerificationToken {

    private final String value;
    private final Instant expiresAt;

    private VerificationToken(String value, Instant expiresAt) {
        this.value = value;
        this.expiresAt = expiresAt;
    }

    public static VerificationToken generate(Duration validity) {

        if (validity == null || validity.isZero() || validity.isNegative()) {
            throw new IllegalArgumentException("Invalid token validity");
        }

        String token = UUID.randomUUID().toString();

        Instant expiry = Instant.now().plus(validity);

        return new VerificationToken(token, expiry);
    }

    public String getValue() {
        return value;
    }

    public boolean isExpired() {
        return !Instant.now().isBefore(expiresAt);
    }

    public boolean isValid(String suppliedToken) {

        return suppliedToken != null
                && value.equals(suppliedToken)
                && !isExpired();
    }
}