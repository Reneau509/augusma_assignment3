// Reneau Augusma
// COP 3330, Spring 2020
// Programming Assignment 3 - Problem 2

public class SavingsAccount
{
    private static double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount(double balance)
    {
        this.savingsBalance = balance;
    }

    public double getSavingsBalance()
    {
        return savingsBalance;
    }

    public void calculateMonthlyInterest()
    {
        double monthlyInterest = (this.savingsBalance * SavingsAccount.annualInterestRate) / 12.0;
        savingsBalance += monthlyInterest;
    }

    public void modifyInterestRate(double newRate)
    {
        SavingsAccount.annualInterestRate = newRate;
    }
}
