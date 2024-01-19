import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {

  /**
   * parent class
   * attributes: the state of account
   * get user input method: calcCheckingWithdraw, calcSavingWithdraw,
   */
  private int customerNumber;
  private int pinNumber;
  private double checkingBalance = 0;
  private double savingBalance = 0;

  Scanner input = new Scanner(System.in);
  DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

  /**
   * getter and setter of attribute
   */
  public int getCustomerNumber() {
    return customerNumber;
  }

  public void setCustomerNumber(int customerNumber) {
    this.customerNumber = customerNumber;
  }

  public int getPinNumber() {
    return pinNumber;
  }

  public void setPinNumber(int pinNumber) {
    this.pinNumber = pinNumber;
  }

  public double getCheckingBalance() {
    return checkingBalance;
  }

  public void setCheckingBalance(double checkingBalance) {
    this.checkingBalance = checkingBalance;
  }

  public double getSavingBalance() {
    return savingBalance;
  }

  public void setSavingBalance(double savingBalance) {
    this.savingBalance = savingBalance;
  }

  /**
   * transaction methods
   */

  public void withdrawFromChecking() {
    System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
    System.out.println("Enter amount to withdraw from Checking Account: $");
    double amount = input.nextDouble();

    if (checkingBalance - amount >= 0 && amount > 0) {
      checkingBalance -= amount;
      System.out.println("Withdrawal successful. New Checking Account Balance: " + moneyFormat.format(checkingBalance));
    } else {
      System.out.println("Error: Invalid withdrawal amount or insufficient funds in Checking Account.\n");
    }
  }


  public void withdrawFromSaving() {
    System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
    System.out.println("Enter amount to withdraw from Saving Account: $");
    double amount = input.nextDouble();

    if (savingBalance - amount >= 0 && amount > 0) {
      savingBalance -= amount;
      System.out.println("Withdrawal successful. New Saving Account Balance: " + moneyFormat.format(savingBalance));
    } else {
      System.out.println("Error: Invalid withdrawal amount or insufficient funds in Saving Account.\n");
    }
  }

  public void depositToChecking() {
    System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
    System.out.print("Enter amount to deposit into Checking Account: $");
    double amount = input.nextDouble();

    if (amount > 0) {
      checkingBalance += amount;
      System.out.println("Deposit successful. New Checking Account Balance: " + moneyFormat.format(checkingBalance));
    } else {
      System.out.println("Error: Invalid deposit amount.\n");
    }
  }

  public void depositToSaving() {
    System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
    System.out.print("Enter amount to deposit into Saving Account: $");
    double amount = input.nextDouble();

    if (amount > 0) {
      savingBalance += amount;
      System.out.println("Deposit successful. New Saving Account Balance: " + moneyFormat.format(savingBalance));
    } else {
      System.out.println("Error: Invalid deposit amount.\n");
    }
  }
}
