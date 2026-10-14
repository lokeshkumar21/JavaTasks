package ExceptionCS;

public class Main {

    public static void main(String[] args) {

        BankService bank = new BankService();

        BankAccount account1 =
                new BankAccount(1001, "Arun", 1000.00);

        BankAccount account2 =
                new BankAccount(1002, "Kumar", 500.00);

        bank.addAccount(account1);
        bank.addAccount(account2);

        System.out.println("=== Banking Transaction System ===");

        try {
            System.out.println("\n1. Successful Deposit");
            bank.deposit(1001, 500);

            System.out.println("\n2. Successful Withdrawal");
            bank.withdraw(1001, 200);

            System.out.println("\n3. Successful Transfer");
            bank.transfer(1001, 1002, 100);

        } catch (AccountNotFoundException
                 | InvalidAmountException
                 | InsufficientBalanceException
                 | TransferFailedException e) {

            System.out.println(e.getMessage());

        } finally {
            System.out.println("Transaction block completed.");
        }

        System.out.println("\n4. Invalid Deposit");

        try {
            bank.deposit(1001, 0);

        } catch (AccountNotFoundException
                 | InvalidAmountException e) {

            System.out.println(e.getMessage());

        }

        System.out.println("\n5. Missing Account");

        try {
            bank.findAccount(1005);

        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n6. Insufficient Balance");

        try {
            bank.withdraw(1002, 1000);

        } catch (AccountNotFoundException
                 | InvalidAmountException
                 | InsufficientBalanceException e) {

            System.out.println(e.getMessage());
        }

        System.out.println("\n7. Invalid Transfer");

        try {
            bank.transfer(1001, 1001, 50);

        } catch (AccountNotFoundException
                 | InvalidAmountException
                 | InsufficientBalanceException
                 | TransferFailedException e) {

            System.out.println(e.getMessage());
        }

        System.out.println("\n8. Final Account Details");

        account1.displayAccountDetails();
        account2.displayAccountDetails();
    }
}