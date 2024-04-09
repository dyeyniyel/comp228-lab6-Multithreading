package exercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class AccountTest extends Application {
    private Account account = new Account();  //creating instance of account class
    private ExecutorService executor = Executors.newFixedThreadPool(3); //Creating a thread pool with 3 threads
    private Random random = new Random(); //for generating random numbers for transaction amounts
    private StringBuilder summary = new StringBuilder(); //for displaying summary of transactions

    @Override
    public void start(Stage primaryStage) {
        Label titleLabel = new Label("Lab 6 - Multithreading");
        titleLabel.setFont(new Font("Arial", 24));
        
        //For Deposit transactions
        Button depositButton = new Button("Deposit");
        depositButton.setPrefSize(75, 40);
        depositButton.setOnAction(e -> {
            List<Transaction> transactions = createTransactions("deposit");
            executeTransactions(transactions);
        });

        //For Withdrawal transactions
        Button withdrawButton = new Button("Withdraw");
        withdrawButton.setPrefSize(75, 40);
        withdrawButton.setOnAction(e -> {
            List<Transaction> transactions = createTransactions("withdraw");
            executeTransactions(transactions);
        });

        //For random combination of Deposit or Withdrawal transactions
        Button randomButton = new Button("Random");
        randomButton.setPrefSize(75, 40);
        randomButton.setOnAction(e -> {
            String[] types = {"deposit", "withdraw"};
            List<Transaction> transactions = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                int amount = random.nextInt(1000); // generates a random amount between 0 and 999 for transaction amounts
                String type = types[random.nextInt(types.length)];
                transactions.add(new Transaction(account, amount, type, summary));
            }
            executeTransactions(transactions);
        });
        

        //Displaying label and buttons
        HBox hbox = new HBox(depositButton, withdrawButton, randomButton);
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(20);

        VBox vbox = new VBox(titleLabel, hbox);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(20);

        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private List<Transaction> createTransactions(String type) {
        List<Transaction> transactions = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int amount = random.nextInt(1000); // generates a random amount between 0 and 999
            transactions.add(new Transaction(account, amount, type, summary));
        }
        return transactions;
    }

    private void executeTransactions(List<Transaction> transactions) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (Transaction transaction : transactions) {
            executor.execute(transaction);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
            //Wait for all tasks to complete before displaying summary window
        }
        JOptionPane.showMessageDialog(null, "Thanks for using this application! \n" + summary.toString()); //showing transaction summary window
        summary.setLength(0); //Clearing the summary for future transactions
    }

    @Override
    public void stop() {
        executor.shutdown();  //Shutting down the executor service when the application is stopped
    }

    public static void main(String[] args) {
        launch(args);
    }
}
