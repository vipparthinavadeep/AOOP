import java.time.Duration;
import java.time.Instant;

public final class EmailVerification {

    private final Instant verifiedAt;
    private final VerificationToken token;

    private EmailVerification(
            Instant verifiedAt,
            VerificationToken token) {

        this.verifiedAt = verifiedAt;
        this.token = token;
    }

    public static EmailVerification pending() {

        return new EmailVerification(
                null,
                VerificationToken.generate(Duration.ofMinutes(15))
        );
    }

    public boolean isVerified() {
        return verifiedAt != null;
    }

    public EmailVerification verify(String suppliedToken) {

        if (isVerified()) {
            throw new IllegalStateException("Email already verified");
        }

        if (!token.isValid(suppliedToken)) {
            throw new IllegalArgumentException(
                    "Invalid or expired verification token"
            );
        }

        return new EmailVerification(Instant.now(), null);
    }

    public VerificationToken getToken() {
        return token;
    }

    public Instant getVerifiedAt() {
        return verifiedAt;
    }
}