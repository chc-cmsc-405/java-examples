# Bank Account Example

CMSC-405 Programming Languages — Java

A bank account example demonstrating custom exceptions, checked vs unchecked exceptions, static members, and the final keyword.

## Files

```
├── BankAccount.java              # Main class — static fields, final fields, exception usage
├── InsufficientFundsException.java  # Custom checked exception with structured data
├── InvalidAccountException.java     # Custom unchecked exception (RuntimeException)
└── Main.java                     # Driver — run this to see everything in action
```

## Running

Open in VS Code and use **Run Java** above `main()` in `Main.java`.

Or from the terminal:

```bash
cd bank-account
javac *.java
java Main
```
