public class Main {

    public static void main(String[] args) {

        UserAccountRepository repository =
                new UserAccountRepository();

        System.out.println("===== USER ACCOUNT MANAGEMENT SYSTEM =====");

        try {

            // 1. Create user details
            EmailAddress email =
                    EmailAddress.of("Nav@gmail.com");

            PhoneNumber phone =
                    PhoneNumber.of("+919876543210");

            PostalAddress address =
                    PostalAddress.of(
                            "Kukatpally",
                            "Hyderabad",
                            "500072",
                            "India"
                    );

            // 2. Register user
            UserAccount user =
                    UserAccount.register(email, phone, address);

            repository.register(user);

            System.out.println("\nUser registered successfully!");

            System.out.println("User ID: " + user.getUserId());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Phone: " + user.getPhone().orElse(null));
            System.out.println("Address: " + user.getAddress().orElse(null));
            System.out.println("Status: " + user.getStatus());

            // 3. Email verification
            String token = user.getVerificationToken();

            System.out.println("\nVerification token: " + token);

            user.verifyEmail(token);

            System.out.println("Email verified: "
                    + user.isEmailVerified());

            // 4. Activate account
            user.activate();

            System.out.println("Account status: "
                    + user.getStatus());

            // 5. Check login
            System.out.println("\nCan user login? "
                    + user.canLogin());

            // 6. Suspend account
            user.suspend();

            System.out.println("\nAccount suspended.");

            System.out.println("Can user login? "
                    + user.canLogin());

            // 7. Delete account
            user.delete();

            System.out.println("\nAccount deleted.");

            System.out.println("Final status: "
                    + user.getStatus());

            System.out.println("Total registered users: "
                    + repository.getTotalUsers());

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());

        }
    }
}