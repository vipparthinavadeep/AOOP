public class BankAccount {
    int accountNumber;
    double balance;

    BankAccount(int acc, double bal) {
        accountNumber = acc;
        balance = bal;
    }

    void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Deposited: " + amount);
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }

    public static void main(String[] args) {
        BankAccount b1 = new BankAccount(12345, 5000);

        b1.display();
        b1.deposit(2000);
        b1.withdraw(1000);
        b1.display();
    }
}