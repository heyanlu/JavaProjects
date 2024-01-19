import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Map;

/**
 * child class of Account get input, set up a data to store the user account and pin method:
 * getLogin(check valid login), getAccountType, getChecking, getSaving
 */
public class AccountOptionsMenu extends Account {

  Scanner menuInput = new Scanner(System.in);
  DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

  private Map<Integer, Integer> data = AccountDataInitializer.initializeData();
  private static final int MENU_EXIT_OPTION = 5;

  public void getLogin() throws IOException {
    int maxAttempts = 3;
    int attempts = 0;

    do {
      try {
        System.out.println("Welcome!");
        System.out.println("Enter your customer Number: ");
        setCustomerNumber(menuInput.nextInt());

        if (data.containsKey(getCustomerNumber())) {
          System.out.println("Enter pin Number: ");
          setPinNumber(menuInput.nextInt());

          if (getPinNumber() == data.get(getCustomerNumber())) {
            System.out.println("Hi, Customer Number: " + getCustomerNumber());
            int cp = getPinNumber();
            int cn = getCustomerNumber();
            getAccountType();
            return;
          } else {
            System.out.println("Incorrect PIN. Please try again.");
          }
        } else {
          System.out.println("Customer account does not exist. Please try again.");
        }
      } catch (Exception e) {
        System.out.println("Invalid input, Please enter numbers!");
        menuInput.nextLine();
      }

      attempts++;
    } while (attempts < maxAttempts);
    System.out.println("Maximum login attempts reached. Exiting.");
  }

  public void getAccountType() {
    System.out.println("Select the account you want to access: ");
    System.out.println("Type 1 - Checking Account");
    System.out.println("Type 2 - Saving Account");
    System.out.println("Type 3 - Exit");

    int selection = menuInput.nextInt();

    switch (selection) {
      case 1:
        getChecking();
        break;
      case 2:
        getSaving();
        break;
      case 3:
        System.out.println("Thank you for using our ATM service!");
        break;
      default:
        System.out.println("Invalid selection. Please choose a valid option.");
        break;
    }
  }

  public void getChecking() {
    int selection;

    do {
      printAccountOptions("Checking Account");

      selection = getMenuSelection();

      switch (selection) {
        case 1:
          System.out.println("Checking account Balance: " + moneyFormat.format(getCheckingBalance()));
          break;
        case 2:
          withdrawFromChecking();
          break;
        case 3:
          depositToChecking();
          break;
        case 4:
          getAccountType();
          break;
        case MENU_EXIT_OPTION:
          System.out.println("Thank you for using our ATM service!");
          break;
        default:
          System.out.println("Invalid selection. Please choose a valid option.");
          getChecking();
      }
    } while (selection != 4 && selection != MENU_EXIT_OPTION);
  }

  public void getSaving() {
    int selection;

    do {
      printAccountOptions("Saving Account");

      selection = getMenuSelection();

      switch (selection) {
        case 1:
          System.out.println("Saving account Balance: " + moneyFormat.format(getSavingBalance()));
          break;
        case 2:
          withdrawFromSaving();
          break;
        case 3:
          depositToSaving();
          break;
        case 4:
          getAccountType();
          break;
        case MENU_EXIT_OPTION:
          System.out.println("Thank you for using our ATM service!");
          break;
        default:
          System.out.println("Invalid selection. Please choose a valid option.");
          getChecking();
      }
    } while (selection != 4 && selection != MENU_EXIT_OPTION);
  }

  private void printAccountOptions(String accountType) {
    System.out.println(accountType + ": ");
    System.out.println("Type 1 - View Balance");
    System.out.println("Type 2 - Withdraw Funds");
    System.out.println("Type 3 - Deposit Funds");
    System.out.println("Type 4 - Back to Account Menu");
    System.out.println("Type " + MENU_EXIT_OPTION + " - Exit");
    System.out.println("Choice: ");
  }

  private int getMenuSelection() {
    while (!menuInput.hasNextInt()) {
      System.out.println("Invalid input. Please enter a number.");
      menuInput.next(); // Consume invalid input
    }
    return menuInput.nextInt();
  }
}
