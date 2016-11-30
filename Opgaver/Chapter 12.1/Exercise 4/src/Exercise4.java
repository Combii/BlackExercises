/**
 * Created by David Stovlbaek on 12/09/16.
 */
public class Exercise4 {

    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private java.util.Date loanDate;

    /** Default constructor */
    public Exercise4(){
        this(2.5, 1, 1000);
    }

    /** Construct a loan with specified annual interest rate,
        number of years, and loan amount
     */
    public Exercise4(double annualInterestRate, int numberOfYears, double loanAmount){
        if(loanAmount <= 0 && annualInterestRate <= 0 && numberOfYears <= 0) throw new IllegalArgumentException();
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        loanDate = new java.util.Date();
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        if(annualInterestRate <= 0) throw new IllegalArgumentException();
        this.annualInterestRate = annualInterestRate;
    }

    public void setNumberOfYears(int numberOfYears) {
        if(numberOfYears <= 0) throw new IllegalArgumentException();
        this.numberOfYears = numberOfYears;
    }

    public void setLoanAmount(double loanAmount) {
        if(loanAmount <= 0) throw new IllegalArgumentException();
        this.loanAmount = loanAmount;
    }

    /** Find monthly payment */
    public double getMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 1200;
        return loanAmount * monthlyInterestRate / (1 -
                (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
    }

    /** Find total payment */
    public double getTotalPayment() {
        return getMonthlyPayment() * numberOfYears * 12;
    }

    /** Return loan date */
    public java.util.Date getLoanDate() {
        return loanDate;
    }

}
