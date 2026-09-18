import java.util.Scanner;

class ATM {
    private bank_account bank_account;

    public ATM(bank_account bank_account) {
        this.bank_account = bank_account;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("==== ATM MENU ====");
            System.out.println("1: Deposit");
            System.out.println("2: Withdraw");
            System.out.println("3: Check Balance");
            System.out.println("4: Exit");

            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please try again.");
                sc.next();
            }

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter amount to deposit: ");

                    while (!sc.hasNextDouble()) {
                        System.out.println("Invalid amount! Please enter a number.");
                        sc.next();
                    }

                    double depositAmount = sc.nextDouble();
                    bank_account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");

                    while (!sc.hasNextDouble()) {
                        System.out.println("Invalid amount! Please enter a number.");
                        sc.next();
                    }

                    double withdrawAmount = sc.nextDouble();
                    bank_account.withdraw(withdrawAmount);
                    break;

                case 3:
                    bank_account.checkBalance();
                    break;

                case 4:
                    System.out.println("Thank you for using ATM!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}

class bank_account {
    private double balance;

    public bank_account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Invalid amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance = balance - amount;
                System.out.println("Withdrawal successful!");
            } else {
                System.out.println("Insufficient balance!");
            }
        } else {
            System.out.println("Invalid amount!");
        }
    }

    public void checkBalance() {
        System.out.println("Your balance is: " + getBalance());
    }
}

public class atm_interface {
    public static void main(String[] args) {

        bank_account account = new bank_account(10000);

        ATM atm = new ATM(account);

        atm.start();
    }
}