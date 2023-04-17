// Nathaniel Budz
// CPSC-24500.002
// PersonalLoan class

package loancalcgui;

public class PersonalLoan extends Loan {

    public PersonalLoan(int loanNumber, String lastName, double loanAmount, int term) {
        
        super(loanNumber, lastName, loanAmount, term);
        
    }

    @Override
    void interestRate(double primeRate) {
        
        this.interestRate = primeRate + 2;
        
    }
}
