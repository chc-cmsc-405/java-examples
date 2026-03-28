/**
 * Session 9 — BankAccount example driver.
 *
 * Run this to see custom exceptions, static members, and final fields in action.
 * Read the output, then read the code. Modify and re-run to experiment.
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("=== Creating Accounts ===");
        BankAccount alice = new BankAccount("Alice", 1000.00);
        BankAccount bob = new BankAccount("Bob", 500.00);
        System.out.println(alice);
        System.out.println(bob);

        // Static method — called on the CLASS, not an instance
        System.out.println("Total accounts: " + BankAccount.getTotalAccounts());
        System.out.println();

        // ----------------------------------------
        // Custom checked exception — InsufficientFundsException
        // ----------------------------------------
        System.out.println("=== Withdrawal: Checked Exception ===");
        try {
            alice.withdraw(200.00);
            System.out.println("Alice withdrew $200.00 — Balance: $" + String.format("%.2f", alice.getBalance()));

            // This will throw InsufficientFundsException
            alice.withdraw(5000.00);
        } catch (InsufficientFundsException e) {
            System.out.println("CAUGHT: " + e.getMessage());
            System.out.println("  Shortfall: $" + String.format("%.2f", e.getShortfall()));
        }
        System.out.println();

        // ----------------------------------------
        // Custom unchecked exception — InvalidAccountException
        // ----------------------------------------
        System.out.println("=== Invalid Operations: Unchecked Exception ===");
        try {
            // This throws InvalidAccountException (unchecked — RuntimeException)
            BankAccount bad = new BankAccount("", 100.00);
        } catch (InvalidAccountException e) {
            System.out.println("CAUGHT: " + e.getMessage());
        }

        try {
            alice.deposit(-50.00);
        } catch (InvalidAccountException e) {
            System.out.println("CAUGHT: " + e.getMessage());
        }
        System.out.println();

        // ----------------------------------------
        // Static members — shared across all instances
        // ----------------------------------------
        System.out.println("=== Static: Interest Rate ===");
        System.out.println("Current rate: " + BankAccount.getInterestRate());

        alice.applyInterest();
        bob.applyInterest();
        System.out.println("After interest:");
        System.out.println("  " + alice);
        System.out.println("  " + bob);

        // Change the rate — affects ALL future interest calculations
        BankAccount.setInterestRate(0.05);
        System.out.println("Rate changed to: " + BankAccount.getInterestRate());

        alice.applyInterest();
        bob.applyInterest();
        System.out.println("After new rate interest:");
        System.out.println("  " + alice);
        System.out.println("  " + bob);
        System.out.println();

        // ----------------------------------------
        // Final fields — immutable after construction
        // ----------------------------------------
        System.out.println("=== Final: Immutable Fields ===");
        System.out.println("Alice's account number: " + alice.getAccountNumber());
        System.out.println("Bob's account number: " + bob.getAccountNumber());
        // alice.accountNumber = "HACKED";  // Won't compile — final field
        // alice.ownerName = "Eve";          // Won't compile — final field
        System.out.println("(Try uncommenting the lines above to see the compiler error)");
    }
}
