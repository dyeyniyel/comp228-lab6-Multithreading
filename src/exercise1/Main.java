package exercise1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JOptionPane;


public class Main extends Application {
    private Account account;
    private ExecutorService executorService;

    @Override
    public void start(Stage primaryStage) {
        // Create an Account instance
        account = new Account(1000.0);

        // Create ExecutorService to manage threads
        executorService = Executors.newCachedThreadPool();
        
        //UI portion of the code
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));
        
        //labels 
        Label titleLabel = new Label("      Welcome!");
        titleLabel.setFont(new Font("Arial", 22));
        titleLabel.setAlignment(Pos.CENTER);
        titleLabel.setPadding(new Insets(0,0,40,0));
 
        Label depositLabel = new Label("Deposit:");
        Label withdrawLabel = new Label("Withdraw:");
        
        
        //textfields
        TextField depositTextField = new TextField();
        TextField withdrawTextField = new TextField();
        depositTextField.setPrefWidth(50); 
        withdrawTextField.setPrefWidth(50); 

        //buttons
        Button depositBtn = new Button("Deposit");
        Button withdrawBtn = new Button("Withdraw");
        Button transactBtn = new Button("Transact both");
        transactBtn.setPrefSize(100, 30);
        Button showBalance = new Button("Display Balance");
        showBalance.setPrefSize(100, 30);
        
        depositBtn.setPrefSize(75, 30);
        withdrawBtn.setPrefSize(75, 30);

        HBox buttonBox = new HBox(10);
        buttonBox.setPadding(new Insets(40,0,0,0));
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(depositBtn, withdrawBtn);

        HBox transactBox = new HBox();
        transactBox.setAlignment(Pos.CENTER);
        transactBox.getChildren().add(transactBtn);
        

        HBox balanceBox = new HBox();
        balanceBox.setAlignment(Pos.CENTER);
        balanceBox.getChildren().add(showBalance);
        
        //Add elements to the grid
        grid.add(titleLabel, 0, 0, 2, 1); //Spanning across 2 columns
        grid.add(depositLabel, 0, 1);
        grid.add(depositTextField, 1, 1);
        grid.add(withdrawLabel, 0, 2);
        grid.add(withdrawTextField, 1, 2);
        grid.add(buttonBox, 0, 3, 2, 1); //Spanning across 2 columns
        grid.add(transactBox, 0, 4, 2, 1); //Spanning across 2 columns
        grid.add(balanceBox, 0, 5, 2, 1); //Spanning across 2 columns
        

        //EVENT HANDLING
        //for deposit button
        depositBtn.setOnAction(e -> {
            if (depositTextField.getText().isEmpty()) { //display error if field is empty when depositing
                JOptionPane.showMessageDialog(null, "Please enter a value in the deposit field.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    double amount = Double.parseDouble(depositTextField.getText());
                    executeTransaction("deposit", amount);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number for the deposit amount.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        //for withdraw button
        withdrawBtn.setOnAction(e -> {
            if (withdrawTextField.getText().isEmpty()) { //display error if field is empty when withdrawing
                JOptionPane.showMessageDialog(null, "Please enter a value in the withdraw field.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    double amount = Double.parseDouble(withdrawTextField.getText());
                    executeTransaction("withdraw", amount);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number for the withdraw amount.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        //for transacting both button
        transactBtn.setOnAction(e -> {
            if (depositTextField.getText().isEmpty() || withdrawTextField.getText().isEmpty()) { //display error any field is empty when transacting both
                JOptionPane.showMessageDialog(null, "Please enter a value in both the deposit and withdraw fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    double depositAmount = Double.parseDouble(depositTextField.getText());
                    double withdrawAmount = Double.parseDouble(withdrawTextField.getText());
                    executeTransaction("deposit", depositAmount);
                    executeTransaction("withdraw", withdrawAmount);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers for both deposit and withdraw amounts.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        //for display balance button
        showBalance.setOnAction(e -> {
            JOptionPane.showMessageDialog(null, "Current balance: $" + account.getBalance(), "Account Balance", JOptionPane.INFORMATION_MESSAGE);
        });


        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Lab6 - MultiThreading");
        primaryStage.show();
    }

    //Method to execute transaction
    private void executeTransaction(String type, double amount) {
        Transaction transaction = new Transaction(account, type, amount);
        executorService.execute(transaction); //execute the threads
    }

    //Method to shutdown executor service
    @Override
    public void stop() {
        executorService.shutdown();
    }

    public static void main(String[] args) {
        launch(args);
    }
}




