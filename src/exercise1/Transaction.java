package exercise1;

public class Transaction implements Runnable {
    private Account account;
    private int amount;
    private String type; //"deposit" or "withdraw"
    private StringBuilder summary;

    
    //Constructor to initialize a Transaction object
    public Transaction(Account account, int amount, String type, StringBuilder summary) {
        this.account = account;
        this.amount = amount;
        this.type = type;
        this.summary = summary;
    }

    @Override
    public void run() {
        if (type.equals("deposit")) { //If object type is deposit
            account.deposit(amount); //Deposit the amount into the account
           
            System.out.println("Deposited: " + amount + ". Current balance: " + account.getBalance());
            summary.append("Deposited: " + amount + ". Current balance: " + account.getBalance() + "\n");

        } else if (type.equals("withdraw")) { //If object type is withdraw
            if (account.getBalance() >= amount) {
                account.withdraw(amount); //Withdraw the amount into the account
                System.out.println("Withdrew: " + amount + ". Current balance: " + account.getBalance());
                summary.append("Withdrew: " + amount + ". Current balance: " + account.getBalance() + "\n");

            } else {   //If insufficient balance, print message and update the summary
                System.out.println("Insufficient balance for withdrawal. Current balance: " + account.getBalance());
                summary.append("Insufficient balance for withdrawal. Current balance: " + account.getBalance() + "\n");
            }
        }
    }
}
