/**
 * A custom checked exception for bank withdrawals.
 *
 * Extends Exception (not RuntimeException), so callers
 * MUST handle it with try/catch or declare throws.
 */
public class InsufficientFundsException extends Exception {
    private double amount;
    private double balance;

    public InsufficientFundsException(double amount, double balance) {
        super("Cannot withdraw $" + String.format("%.2f", amount)
              + ". Balance: $" + String.format("%.2f", balance));
        this.amount = amount;
        this.balance = balance;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public double getShortfall() {
        return amount - balance;
    }
}
