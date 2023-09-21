package homework47_48.bank;

public class Account {
    private String accountNumber;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "Account: " + accountNumber;
    }
}
