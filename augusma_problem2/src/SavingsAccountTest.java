// Reneau Augusma
// COP 3330, Spring 2020
// Programming Assignment 3 - Problem 2

import java.text.DecimalFormat;

public class SavingsAccountTest
{
    public static void main(String[] args)
    {
        DecimalFormat dec = new DecimalFormat("####0.00");
        SavingsAccount saver1 = new SavingsAccount(2000.00), saver2 = new SavingsAccount(3000.00);

        saver1.modifyInterestRate(0.04);
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.println("Monthly balances for both accounts: $" + dec.format(saver1.getSavingsBalance()) +
                " and $" + dec.format(saver2.getSavingsBalance()));

        saver2.modifyInterestRate(0.05);
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.println("Next month's monthly balances for both accounts: $" + dec.format(saver1.getSavingsBalance()) +
                " and $" + dec.format(saver2.getSavingsBalance()));

    }
}
