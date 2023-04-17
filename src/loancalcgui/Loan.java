// Nathaniel Budz
// CPSC-24500.002
// Loan class

package loancalcgui;

public abstract class Loan implements LoanConstants {
    
    private int loanNumber;
    private String lastName;
    private double loanAmount;
    protected double interestRate;
    private int term;

    public Loan() {
        
    }

    public Loan(int loanNumber, String lastName, double loanAmount, int term) {
        
        this.loanNumber = loanNumber;
        this.lastName = lastName;
        
        // Does not allow the user to have a loan larger than 500000
        if (loanAmount > MAXIMUM_LOAN_AMOUNT) {
            
            this.loanAmount = MAXIMUM_LOAN_AMOUNT;
            
        } else {
            
            this.loanAmount = loanAmount;
            
        }
        
        switch(term) {
            
            case 1: this.term = SHORT_TERM;
                    break;
            case 3: this.term = MEDIUM_TERM;
                    break;
            case 5: this.term = LONG_TERM;
                    break;
            default: this.term = SHORT_TERM;
                    break;
        }
    }

    public int getLoanNumber() {
        
        return loanNumber;
        
    }

    public void setLoanNumber(int loanNumber) {
        
        this.loanNumber = loanNumber;
        
    }

    public String getLastName() {
        
        return lastName;
        
    }

    public void setLastName(String lastName) {
        
        this.lastName = lastName;
        
    }

    public double getLoanAmount() {
        
        return loanAmount;
        
    }

    public void setLoanAmount(double loanAmount) {
        
        // Does not allow the user to have a loan larger than 500000
        if (loanAmount > MAXIMUM_LOAN_AMOUNT) {
            
            this.loanAmount = MAXIMUM_LOAN_AMOUNT;
            
        } else {
            
            this.loanAmount = loanAmount;
            
        }
        
    }

    public double getInterestRate() {
        
        return interestRate;
        
    }

    public int getTerm() {
        
        return term;
        
    }

    public void setTerm(int term) {
       
        switch(term) {
            
            case 1: this.term = SHORT_TERM;
                    break;
            case 3: this.term = MEDIUM_TERM;
                    break;
            case 5: this.term = LONG_TERM;
                    break;
            default: this.term = SHORT_TERM;
                    break;
      
        }
    }

    @Override
    public String toString() {
        return  "Loan Number: " + loanNumber + "\n"
                + "Last Name: " + lastName + "\n"
                + "Loan Amount: $" + loanAmount + "\n"
                + "Interest Rate: %" + interestRate + "\n"
                + "Term: " + term + " Year Loan";
    }
    
    abstract void interestRate(double primeRate);
    
}
