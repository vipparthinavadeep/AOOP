import java.util.HashMap;
import java.util.Map;

public class UserAccountRepository {

    private final Map<String, UserAccount> users = new HashMap<>();

    public void register(UserAccount user) {

        String email = user.getEmail().getValue();

        if (users.containsKey(email)) {
            throw new IllegalArgumentException(
                    "An account with this email already exists"
            );
        }

        users.put(email, user);
    }

    public UserAccount findByEmail(String email) {

        return users.get(email.toLowerCase());
    }

    public int getTotalUsers() {
        return users.size();
    }
}