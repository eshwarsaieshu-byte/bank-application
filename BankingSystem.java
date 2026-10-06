import java.util.Scanner;

class Account {
    String holderName;
    int accountNumber;
    double balance;

    Account(String holderName, int accountNumber, double balance) {
        this.holderName = holderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Amount deposited successfully");
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            System.out.println("Amount withdrawn successfully");
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount");
        } else {
            System.out.println("Insufficient balance");
        }
    }

    void display() {
        System.out.println("\n--- ACCOUNT DETAILS ---");
        System.out.println("Account Holder: " + holderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}


// Savings Account
class SavingsAccount extends Account {

    SavingsAccount(String name, int number, double balance) {
        super(name, number, balance);
    }

    @Override
    void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount");
        }
        else if (balance - amount >= 1000) {
            balance = balance - amount;
            System.out.println("Savings withdrawal successful");
        }
        else {
            System.out.println("Minimum balance of 1000 required");
        }
    }
}


// Current Account
class CurrentAccount extends Account {

    CurrentAccount(String name, int number, double balance) {
        super(name, number, balance);
    }

    @Override
    void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount");
        }
        else if (amount <= balance + 5000) {
            balance = balance - amount;
            System.out.println("Current account withdrawal successful");
        }
        else {
            System.out.println("Overdraft limit exceeded");
        }
    }
}


// Salary Account
class SalaryAccount extends Account {

    SalaryAccount(String name, int number, double balance) {
        super(name, number, balance);
    }

    @Override
    void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount");
        }
        else if (amount <= balance) {
            balance = balance - amount;
            System.out.println("Salary account withdrawal successful");
        }
        else {
            System.out.println("Insufficient balance");
        }
    }
}


// Fixed Deposit Account
class FixedDepositAccount extends Account {

    FixedDepositAccount(String name, int number, double balance) {
        super(name, number, balance);
    }

    @Override
    void withdraw(double amount) {
        System.out.println("Withdrawal is not allowed from Fixed Deposit");
    }
}


// Main Class
public class BankingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("       BANKING SYSTEM");
        System.out.println("================================");

        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.println("3. Salary Account");
        System.out.println("4. Fixed Deposit Account");

        System.out.print("Enter account type: ");
        int type = sc.nextInt();

        if (type < 1 || type > 4) {
            System.out.println("Invalid account type");
            sc.close();
            return;
        }

        sc.nextLine();

        System.out.print("Enter holder name: ");
        String name = sc.nextLine();

        System.out.print("Enter account number: ");
        int number = sc.nextInt();

        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();

        if (balance < 0) {
            System.out.println("Initial balance cannot be negative");
            sc.close();
            return;
        }

        Account account;

        if (type == 1) {
            account = new SavingsAccount(name, number, balance);
        }
        else if (type == 2) {
            account = new CurrentAccount(name, number, balance);
        }
        else if (type == 3) {
            account = new SalaryAccount(name, number, balance);
        }
        else {
            account = new FixedDepositAccount(name, number, balance);
        }


        int choice;

        do {

            System.out.println("\n================================");
            System.out.println("          BANK MENU");
            System.out.println("================================");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Account");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();


            switch (choice) {

                case 1:

                    System.out.print("Enter amount to deposit: ");
                    double deposit = sc.nextDouble();

                    account.deposit(deposit);

                    break;


                case 2:

                    System.out.print("Enter amount to withdraw: ");
                    double withdraw = sc.nextDouble();

                    account.withdraw(withdraw);

                    break;


                case 3:

                    account.display();

                    break;


                case 4:

                    System.out.println("Thank you for using Banking System!");

                    break;


                default:

                    System.out.println("Invalid choice");

            }

        } while (choice != 4);


        sc.close();
    }
}