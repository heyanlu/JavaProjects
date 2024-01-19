import java.io.IOException;

/**
 * main class: User Interface(display menu), get user login
 */
public class ATM extends AccountOptionsMenu {

  public static void main(String[] args) throws IOException {
    AccountOptionsMenu accountOptionsMenu = new AccountOptionsMenu();

    accountOptionsMenu.getLogin();
  }
}