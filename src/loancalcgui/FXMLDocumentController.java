// Nathaniel Budz
// CPSC-24500.002
// Asks user to input loan data, and then shows all of the loans for the
// user to see on the right side of the screen

package loancalcgui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable {
    
    // Initializes all of the FXML pieces
    @FXML
    private TextArea txtArea;
    
    @FXML
    private ChoiceBox ddlType;
    
    @FXML
    private TextField txtNumber;
    
    @FXML
    private TextField txtName;
    
    @FXML
    private TextField txtAmount;
    
    @FXML
    private TextField txtRate;
    
    @FXML
    private RadioButton radShort;
    
    @FXML
    private RadioButton radMedium;
    
    @FXML
    private RadioButton radLong;
    
    ArrayList<Loan> loanList = new ArrayList();
    
    @FXML
    private void handleBtnExit(ActionEvent event) {

        Platform.exit();
    }
    
    @FXML
    private void handleBtnInput(ActionEvent event) {
        
        // Method call
        addResults();
        
        // Clears out all of the text fields so the user can enter next value
        txtRate.setDisable(true);
        txtNumber.setText("");
        txtName.setText("");
        txtAmount.setText("");
        ddlType.setValue("Personal");
        radShort.setSelected(true);
        
    }
    
    @FXML
    private void handleBtnResults(ActionEvent event) {
        
        // Clears out the textarea so it doesnt repeat entered values
        txtArea.setText("");
        
        for(int i = 0; i < loanList.size(); i++) {
                
            // Checks to see what type of loan it is
            if (loanList.get(i) instanceof BusinessLoan) {

                // Formatting
                txtArea.appendText("Business Loan" + "\n");
                txtArea.appendText("=====================" + "\n");
                txtArea.appendText(loanList.get(i).toString() + "\n");
                txtArea.appendText("Total due after term: $");

                // Sends the users loan data to a method that
                // calculates how much they will owe
                String formattedTotal = String.format("%.2f", 
                        calculateTotal(loanList.get(i).getTerm(), 
                                loanList.get(i).getInterestRate(), 
                                loanList.get(i).getLoanAmount()));

                txtArea.appendText(formattedTotal);

                txtArea.appendText("\n");
                txtArea.appendText("\n");

            } else {

                // Formatting
                txtArea.appendText("Personal Loan" + "\n");
                txtArea.appendText("=====================" + "\n");
                txtArea.appendText(loanList.get(i).toString() + "\n");
                txtArea.appendText("Total due after term: $");

                // Sends the users loan data to a method that
                // calculates how much they will owe
                String formattedTotal = String.format("%.2f", 
                        calculateTotal(loanList.get(i).getTerm(), 
                                loanList.get(i).getInterestRate(), 
                                loanList.get(i).getLoanAmount()));

                txtArea.appendText(formattedTotal);

                txtArea.appendText("\n");
                txtArea.appendText("\n");

            }
        }
    }

    public double calculateTotal(int loanTerm, double rate, double amount){
        
        // Converts interest rate into a percent and then finds the rate per month
        double ratePerMonth = rate / 100 / 12;
        
        // Calculates the months in the loan term
        int months = loanTerm * 12;
        
        // Half of the equation for calculating the interest of the loan
        double topEquation = (amount * ratePerMonth * (double) Math.pow(1 + ratePerMonth, months));
        
        // The other half of the equation
        double bottomEquation = (double) Math.pow(1 + ratePerMonth, months) - 1;
        
        // The equation put together
        double monthlyPayment = topEquation / bottomEquation;
        
        return monthlyPayment * months;
        
    }
    
    public void addResults() {
        
        try {
            
            // Initializes variables
            // Takes the data from the text fields and other GUI
            // fields and inputs them into a arraylist
            double primeRate = Double.parseDouble(txtRate.getText());
            int loanNum = Integer.parseInt(txtNumber.getText()); 
            String lastName = txtName.getText().toUpperCase();
            double loanAmount = Double.parseDouble(txtAmount.getText());
            int term = 1;
            
            // deceiphers which radio button is selected
            if (radShort.isSelected()) {

                term = 1;

            } else if (radMedium.isSelected()) {

                term = 3;

            } else if (radLong.isSelected()){

                term = 5;

            }
            
            // Creates the appropriate loan object and adds to array
            if (ddlType.getValue().equals("Business")) {

                BusinessLoan bLoan = new BusinessLoan(loanNum, lastName, loanAmount, term);
                bLoan.interestRate(primeRate);
                loanList.add(bLoan);

                } else {

                PersonalLoan pLoan = new PersonalLoan(loanNum, lastName, loanAmount, term);
                pLoan.interestRate(primeRate);
                loanList.add(pLoan);
                
                }
            
        } catch(NumberFormatException ex) {
            
            // If the user enters invalid data
            System.out.println("Make sure you are entering appropriate values!");
            
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // Sets the choice box values on start up
        // also sets the choicebox choice to personal on start up
        ddlType.getItems().addAll("Personal", "Business");
        ddlType.setValue("Personal");
        
    }    
}
