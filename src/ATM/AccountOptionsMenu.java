package ATM;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;

public class AccountOptionsMenu extends Account {
  Scanner menuInput;
  DecimalFormat moneyFormat;
  private Map<Integer, Integer> data;
  private static final int MENU_EXIT_OPTION = 5;

  public AccountOptionsMenu() {
    this.menuInput = new Scanner(System.in);
    this.moneyFormat = new DecimalFormat("'$'###,##0.00");
    this.data = AccountDataInitializer.initializeData();
  }

  public void getLogin() throws IOException {
    int maxAttempts = 3;
    int attempts = 0;

    do {
      try {
        System.out.println("Welcome!");
        System.out.println("Enter your customer Number: ");
        this.setCustomerNumber(this.menuInput.nextInt());
        if (this.data.containsKey(this.getCustomerNumber())) {
          System.out.println("Enter pin Number: ");
          this.setPinNumber(this.menuInput.nextInt());
          if (this.getPinNumber() == (Integer)this.data.get(this.getCustomerNumber())) {
            System.out.println("Hi, Customer Number: " + this.getCustomerNumber());
            int cp = this.getPinNumber();
            int cn = this.getCustomerNumber();
            this.getAccountType();
            return;
          }

          System.out.println("Incorrect PIN. Please try again.");
        } else {
          System.out.println("Customer account does not exist. Please try again.");
        }
      } catch (Exception var5) {
        System.out.println("Invalid input, Please enter numbers!");
        this.menuInput.nextLine();
      }

      ++attempts;
    } while(attempts < maxAttempts);

    System.out.println("Maximum login attempts reached. Exiting.");
  }

  public void getAccountType() {
    System.out.println("Select the account you want to access: ");
    System.out.println("Type 1 - Checking Account");
    System.out.println("Type 2 - Saving Account");
    System.out.println("Type 3 - Exit");
    int selection = this.menuInput.nextInt();
    switch (selection) {
      case 1:
        this.getChecking();
        break;
      case 2:
        this.getSaving();
        break;
      case 3:
        System.out.println("Thank you for using our ATM service!");
        break;
      default:
        System.out.println("Invalid selection. Please choose a valid option.");
    }

  }

  public void getChecking() {
    int selection;
    do {
      this.printAccountOptions("Checking Account");
      selection = this.getMenuSelection();
      switch (selection) {
        case 1:
          DecimalFormat var10001 = this.moneyFormat;
          System.out.println("Checking account Balance: " + var10001.format(this.getCheckingBalance()));
          break;
        case 2:
          this.withdrawFromChecking();
          break;
        case 3:
          this.depositToChecking();
          break;
        case 4:
          this.getAccountType();
          break;
        case 5:
          System.out.println("Thank you for using our ATM service!");
          break;
        default:
          System.out.println("Invalid selection. Please choose a valid option.");
          this.getChecking();
      }
    } while(selection != 4 && selection != 5);

  }

  public void getSaving() {
    int selection;
    do {
      this.printAccountOptions("Saving Account");
      selection = this.getMenuSelection();
      switch (selection) {
        case 1:
          DecimalFormat var10001 = this.moneyFormat;
          System.out.println("Saving account Balance: " + var10001.format(this.getSavingBalance()));
          break;
        case 2:
          this.withdrawFromSaving();
          break;
        case 3:
          this.depositToSaving();
          break;
        case 4:
          this.getAccountType();
          break;
        case 5:
          System.out.println("Thank you for using our ATM service!");
          break;
        default:
          System.out.println("Invalid selection. Please choose a valid option.");
          this.getChecking();
      }
    } while(selection != 4 && selection != 5);

  }

  private void printAccountOptions(String accountType) {
    System.out.println(accountType + ": ");
    System.out.println("Type 1 - View Balance");
    System.out.println("Type 2 - Withdraw Funds");
    System.out.println("Type 3 - Deposit Funds");
    System.out.println("Type 4 - Back to Account Menu");
    System.out.println("Type 5 - Exit");
    System.out.println("Choice: ");
  }

  private int getMenuSelection() {
    while(!this.menuInput.hasNextInt()) {
      System.out.println("Invalid input. Please enter a number.");
      this.menuInput.next();
    }

    return this.menuInput.nextInt();
  }
}
