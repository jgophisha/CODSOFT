package task3;
import java.util.HashMap;
import java.util.Scanner;

// Represents a single bank account
class BankAccount {
    private int accountNumber;
    private int pin;
    private double balance;

    public BankAccount(int accountNumber, int pin, double initialBalance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = initialBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public boolean verifyPin(int inputPin) {
        return this.pin == inputPin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Successfully withdrew: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
        }
    }
}

// Represents the ATM machine that interacts with bank accounts
class ATM {
    private HashMap<Integer, BankAccount> accounts = new HashMap<>();
    private BankAccount currentAccount = null;

    public void addAccount(int accountNumber, int pin, double initialBalance) {
        accounts.put(accountNumber, new BankAccount(accountNumber, pin, initialBalance));
    }

    public boolean authenticate(int accountNumber, int pin) {
        BankAccount account = accounts.get(accountNumber);
        if (account != null && account.verifyPin(pin)) {
            currentAccount = account;
            return true;
        } else {
            return false;
        }
    }

    public void showOptions() {
        if (currentAccount != null) {
            Scanner scanner = new Scanner(System.in);
            int choice;
            do {
                System.out.println("\n--- ATM Menu ---");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Current Balance: $" + currentAccount.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter deposit amount: $");
                        double depositAmount = scanner.nextDouble();
                        currentAccount.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter withdrawal amount: $");
                        double withdrawalAmount = scanner.nextDouble();
                        currentAccount.withdraw(withdrawalAmount);
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        currentAccount = null;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } while (choice != 4);
        } else {
            System.out.println("Authentication failed. Please try again.");
        }
    }
}

// Represents the main application that initializes and runs the ATM system
public class ATMApplication {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.addAccount(123456, 1234, 5000.00);
        atm.addAccount(987654, 4321, 3000.00);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your account number: ");
        int accountNumber = scanner.nextInt();
        System.out.print("Enter your PIN: ");
        int pin = scanner.nextInt();

        if (atm.authenticate(accountNumber, pin)) {
            atm.showOptions();
        } else {
            System.out.println("Invalid account number or PIN.");
            atm.showOptions();
        }
    }
}
