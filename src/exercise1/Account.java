package exercise1;

import javax.swing.JOptionPane;

public class Account {
    private double balance;


    public Account(double balance) {
        this.balance = balance;
    }

    //allow thread synchronization
    //Synchronized method to deposit 
    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit: $" + amount + "\nNew Balance: " + balance);
        JOptionPane.showMessageDialog(null, "Deposit: $" + amount + "\nNew Balance: " + balance);
    }


    // Synchronized method to withdraw 
    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdraw: $" + amount + "\nNew Balance: " + balance);
            JOptionPane.showMessageDialog(null, "Withdraw: $" + amount + "\nNew Balance: " + balance);
        } else {
            System.out.println("Insufficient balance for withdrawal.");
            JOptionPane.showMessageDialog(null, "Insufficient balance for withdrawal. Current balance is $" + balance);
        }
    }

	public double getBalance() {
		return balance;
	}


}