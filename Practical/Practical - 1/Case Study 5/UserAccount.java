import java.util.Optional;
import java.util.UUID;

public class UserAccount {

    private final String userId;
    private final EmailAddress email;

    private EmailVerification emailVerification;

    private final Optional<PhoneNumber> phone;
    private final Optional<PostalAddress> address;

    private AccountStatus status;

    private UserAccount(
            EmailAddress email,
            PhoneNumber phone,
            PostalAddress address) {

        this.userId = UUID.randomUUID().toString();
        this.email = email;
        this.emailVerification = EmailVerification.pending();

        this.phone = Optional.ofNullable(phone);
        this.address = Optional.ofNullable(address);

        this.status = AccountStatus.PENDING;
    }

    // Register a new user
    public static UserAccount register(
            EmailAddress email,
            PhoneNumber phone,
            PostalAddress address) {

        if (email == null) {
            throw new IllegalArgumentException("Email is required");
        }

        return new UserAccount(email, phone, address);
    }

    // Get user details
    public String getUserId() {
        return userId;
    }

    public EmailAddress getEmail() {
        return email;
    }

    public Optional<PhoneNumber> getPhone() {
        return phone;
    }

    public Optional<PostalAddress> getAddress() {
        return address;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public boolean isEmailVerified() {
        return emailVerification.isVerified();
    }

    // Get verification token
    public String getVerificationToken() {

        if (emailVerification.isVerified()) {
            throw new IllegalStateException("Email already verified");
        }

        return emailVerification.getToken().getValue();
    }

    // Verify email
    public void verifyEmail(String suppliedToken) {

        if (status != AccountStatus.PENDING) {
            throw new IllegalStateException(
                    "Only pending accounts can verify email"
            );
        }

        emailVerification =
                emailVerification.verify(suppliedToken);
    }

    // Activate account
    public void activate() {

        if (status != AccountStatus.PENDING) {
            throw new IllegalStateException(
                    "Only pending accounts can be activated"
            );
        }

        if (!emailVerification.isVerified()) {
            throw new IllegalStateException(
                    "Verify email before activation"
            );
        }

        status = AccountStatus.ACTIVE;
    }

    // Suspend account
    public void suspend() {

        if (status != AccountStatus.ACTIVE) {
            throw new IllegalStateException(
                    "Only active accounts can be suspended"
            );
        }

        status = AccountStatus.SUSPENDED;
    }

    // Delete account
    public void delete() {

        if (status == AccountStatus.DELETED) {
            throw new IllegalStateException(
                    "Account already deleted"
            );
        }

        status = AccountStatus.DELETED;
    }

    // Check login permission
    public boolean canLogin() {

        return status == AccountStatus.ACTIVE
                && emailVerification.isVerified();
    }
}