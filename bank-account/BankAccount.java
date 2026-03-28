/**
 * A bank account demonstrating custom exceptions, static members, and final fields.
 *
 * Session 9 example — run this, read it, modify it.
 */
public class BankAccount {

    // ========================================
    // Static members — belong to the CLASS, not any instance
    // ========================================

    private static int totalAccounts = 0;          // shared counter across all accounts
    private static final double MIN_BALANCE = 0.0; // constant — can never change
    private static double interestRate = 0.02;     // shared rate, can be updated

    // ========================================
    // Final fields — set once, never changed
    // ========================================

    private final String accountNumber;  // set in constructor, immutable
    private final String ownerName;      // set in constructor, immutable

    // ========================================
    // Regular fields
    // ========================================

    private double balance;

    // ========================================
    // Constructor
    // ========================================

    public BankAccount(String ownerName, double initialDeposit) {
        if (ownerName == null || ownerName.isEmpty()) {
            throw new InvalidAccountException("Owner name cannot be null or empty");
        }
        if (initialDeposit < 0) {
            throw new InvalidAccountException("Initial deposit cannot be negative");
        }

        totalAccounts++;
        this.accountNumber = "ACCT-" + String.format("%04d", totalAccounts);
        this.ownerName = ownerName;
        this.balance = initialDeposit;
    }

    // ========================================
    // Methods using exceptions
    // ========================================

    /**
     * Withdraw money from the account.
     *
     * This throws a CHECKED exception — InsufficientFundsException.
     * The caller MUST handle it (try/catch or throws).
     */
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidAccountException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new InsufficientFundsException(amount, balance);
        }
        balance -= amount;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new InvalidAccountException("Deposit amount must be positive");
        }
        balance += amount;
    }

    /**
     * Apply interest to this account using the bank-wide rate.
     */
    public void applyInterest() {
        balance += balance * interestRate;
    }

    // ========================================
    // Getters
    // ========================================

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    // ========================================
    // Static methods — called on the CLASS
    // ========================================

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double rate) {
        interestRate = rate;
    }

    // ========================================
    // toString
    // ========================================

    @Override
    public String toString() {
        return accountNumber + " (" + ownerName + ") — $" + String.format("%.2f", balance);
    }
}
