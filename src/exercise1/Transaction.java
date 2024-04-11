package exercise1;

class Transaction implements Runnable {
    private Account account;
    private String type;
    private double amount;



    public Transaction(Account account, String type, double amount) {
        this.account = account;
        this.type = type;
        this.amount = amount;

    }

    //deposit and withdraw operations in run method
    public void run() {
        if (type.equals("deposit")) {
            account.deposit(amount);     
        } else if (type.equals("withdraw")) {
            account.withdraw(amount);
        }      
    }
}