package ExceptionCS;

import java.util.HashMap;
import java.util.Map;

public class BankService {

    private Map<Integer, BankAccount> accounts = new HashMap<>();

    public void addAccount(BankAccount account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public BankAccount findAccount(int accountNumber)
            throws AccountNotFoundException {

        BankAccount account = accounts.get(accountNumber);

        if (account == null) {
            throw new AccountNotFoundException(
                    "Transaction failed: Account "
                            + accountNumber + " was not found."
            );
        }

        return account;
    }

    public void deposit(int accountNumber, double amount)
            throws AccountNotFoundException,
            InvalidAmountException {

        BankAccount account = findAccount(accountNumber);

        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Transaction failed: Amount must be greater than zero."
            );
        }

        account.deposit(amount);

        System.out.printf(
                "Deposit successful. New balance: €%.2f%n",
                account.getBalance()
        );
    }

    public void withdraw(int accountNumber, double amount)
            throws AccountNotFoundException,
            InvalidAmountException,
            InsufficientBalanceException {

        BankAccount account = findAccount(accountNumber);

        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Transaction failed: Amount must be greater than zero."
            );
        }

        if (amount > account.getBalance()) {
            throw new InsufficientBalanceException(
                    String.format(
                            "Transaction failed: Insufficient balance. "
                                    + "Available: €%.2f, Requested: €%.2f.",
                            account.getBalance(), amount
                    )
            );
        }

        account.withdraw(amount);

        System.out.printf(
                "Withdrawal successful. New balance: €%.2f%n",
                account.getBalance()
        );
    }

    public void transfer(int sourceAccountNumber,
                         int destinationAccountNumber,
                         double amount)
            throws AccountNotFoundException,
            InvalidAmountException,
            InsufficientBalanceException,
            TransferFailedException {

        if (sourceAccountNumber == destinationAccountNumber) {
            throw new TransferFailedException(
                    "Transaction failed: Source and destination accounts "
                            + "cannot be the same."
            );
        }

        BankAccount source = findAccount(sourceAccountNumber);
        BankAccount destination = findAccount(destinationAccountNumber);

        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Transaction failed: Amount must be greater than zero."
            );
        }

        if (amount > source.getBalance()) {
            throw new InsufficientBalanceException(
                    String.format(
                            "Transaction failed: Insufficient balance. "
                                    + "Available: €%.2f, Requested: €%.2f.",
                            source.getBalance(), amount
                    )
            );
        }

        // Update balances only after all validations pass.
        source.withdraw(amount);
        destination.deposit(amount);

        System.out.println("Transfer successful.");

        System.out.printf(
                "Source account balance: €%.2f%n",
                source.getBalance()
        );

        System.out.printf(
                "Destination account balance: €%.2f%n",
                destination.getBalance()
        );
    }
}