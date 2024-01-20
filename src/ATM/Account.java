package ATM;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
  private int customerNumber;
  private int pinNumber;
  private double checkingBalance = 0.0;
  private double savingBalance = 0.0;
  Scanner input;
  DecimalFormat moneyFormat;

  public Account() {
    this.input = new Scanner(System.in);
    this.moneyFormat = new DecimalFormat("'$'###,##0.00");
  }

  public int getCustomerNumber() {
    return this.customerNumber;
  }

  public void setCustomerNumber(int customerNumber) {
    this.customerNumber = customerNumber;
  }

  public int getPinNumber() {
    return this.pinNumber;
  }

  public void setPinNumber(int pinNumber) {
    this.pinNumber = pinNumber;
  }

  public double getCheckingBalance() {
    return this.checkingBalance;
  }

  public void setCheckingBalance(double checkingBalance) {
    this.checkingBalance = checkingBalance;
  }

  public double getSavingBalance() {
    return this.savingBalance;
  }

  public void setSavingBalance(double savingBalance) {
    this.savingBalance = savingBalance;
  }

  public void withdrawFromChecking() {
    System.out.println("Checking Account Balance: " + this.moneyFormat.format(this.checkingBalance));
    System.out.println("Enter amount to withdraw from Checking Account: $");
    double amount = this.input.nextDouble();
    if (this.checkingBalance - amount >= 0.0 && amount > 0.0) {
      this.checkingBalance -= amount;
      System.out.println("Withdrawal successful. New Checking Account Balance: " + this.moneyFormat.format(this.checkingBalance));
    } else {
      System.out.println("Error: Invalid withdrawal amount or insufficient funds in Checking Account.\n");
    }

  }

  public void withdrawFromSaving() {
    System.out.println("Saving Account Balance: " + this.moneyFormat.format(this.savingBalance));
    System.out.println("Enter amount to withdraw from Saving Account: $");
    double amount = this.input.nextDouble();
    if (this.savingBalance - amount >= 0.0 && amount > 0.0) {
      this.savingBalance -= amount;
      System.out.println("Withdrawal successful. New Saving Account Balance: " + this.moneyFormat.format(this.savingBalance));
    } else {
      System.out.println("Error: Invalid withdrawal amount or insufficient funds in Saving Account.\n");
    }

  }

  public void depositToChecking() {
    System.out.println("Checking Account Balance: " + this.moneyFormat.format(this.checkingBalance));
    System.out.print("Enter amount to deposit into Checking Account: $");
    double amount = this.input.nextDouble();
    if (amount > 0.0) {
      this.checkingBalance += amount;
      System.out.println("Deposit successful. New Checking Account Balance: " + this.moneyFormat.format(this.checkingBalance));
    } else {
      System.out.println("Error: Invalid deposit amount.\n");
    }

  }

  public void depositToSaving() {
    System.out.println("Saving Account Balance: " + this.moneyFormat.format(this.savingBalance));
    System.out.print("Enter amount to deposit into Saving Account: $");
    double amount = this.input.nextDouble();
    if (amount > 0.0) {
      this.savingBalance += amount;
      System.out.println("Deposit successful. New Saving Account Balance: " + this.moneyFormat.format(this.savingBalance));
    } else {
      System.out.println("Error: Invalid deposit amount.\n");
    }

  }
}
