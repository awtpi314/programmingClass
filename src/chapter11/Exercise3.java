package chapter11;

import java.time.LocalDate;

public class Exercise3 {
    public static void main(String[] args) {
        Account account = new Account(12345, 123.45, 4.5, LocalDate.of(2017, 1, 1));
        CheckingAccount checkingAccount = new CheckingAccount(23456, 234.56, 4.5, LocalDate.of(2017, 1, 2), 100.00);
        SavingsAccount savingsAccount = new SavingsAccount(54321, 5432.10, 6.6, LocalDate.of(2017, 1, 2), 5332.10);
        System.out.println(account.toString());
        System.out.println(checkingAccount.toString());
        System.out.println(savingsAccount.toString());
    }
}

class Account {
    protected final int id;
    protected final LocalDate dateCreated;
    protected double balance;
    protected double rate;

    public Account(int i, double b, double r, LocalDate dC) {
        id = i;
        balance = b;
        rate = r;
        dateCreated = dC;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void deposit(double money) {
        balance += money;
    }

    public void withdraw(double money) throws Exception {
        if (money > balance) {
            throw new Exception("Not enough money in account.");
        } else {
            balance -= money;
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": id=" + id + String.format(", balance=%.2f", balance) + ", rate=" + rate + "%, created=" + dateCreated.toString();
    }
}

class CheckingAccount extends Account {
    protected double overdraftLimit;

    public CheckingAccount(int i, double d, double r, LocalDate dC, double ovrL) {
        super(i, d, r, dC);
        overdraftLimit = ovrL;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double money) throws Exception {
        if (money > super.balance + overdraftLimit) {
            throw new Exception("Not enough money in account.");
        } else {
            balance -= money;
        }
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", overdraft=%.2f", overdraftLimit);
    }
}

class SavingsAccount extends Account {
    protected double available;

    public SavingsAccount(int i, double d, double r, LocalDate dC, double a) {
        super(i, d, r, dC);
        available = a;
    }

    public double getAvailable() {
        return available;
    }

    public void setAvailable(double available) {
        this.available = available;
    }

    @Override
    public void withdraw(double money) throws Exception {
        if (money > available) {
            throw new Exception("Not enough money in account.");
        } else {
            available -= money;
            balance -= money;
        }
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", available=%.2f", available);
    }
}