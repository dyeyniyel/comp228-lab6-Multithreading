package exercise1;

public class Account {
    private int balance = 10000;

    public int getBalance() {
        return balance;
    }

    public synchronized void deposit(int amount) {
        int newBalance = balance + amount;  //deposit amount
        try {
            Thread.sleep(50); // simulate some database or network delay
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        balance = newBalance;

    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            int newBalance = balance - amount;  //withdraw amount
            try {
                Thread.sleep(50); // simulate some database or network delay
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            balance = newBalance;
        } else {
            System.out.println("Insufficient balance for withdrawal. Current balance: " + balance);
        }
    }
}

