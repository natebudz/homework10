// Nathaniel Budz
// CPSC-24500.002
// BusinessLoan class

package loancalcgui;

public class BusinessLoan extends Loan{

    public BusinessLoan(int loanNumber, String lastName, double loanAmount, int term) {
        
        super(loanNumber, lastName, loanAmount, term);
        
    }

    @Override
    void interestRate(double primeRate) {
        
        this.interestRate = primeRate + 1;
        
    }
}
