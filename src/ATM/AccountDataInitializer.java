package ATM;

import java.util.HashMap;
import java.util.Map;

public class AccountDataInitializer {

  public static Map<Integer, Integer> initializeData() {
    Map<Integer, Integer> data = new HashMap<>();

    data.put(123456, 654321);
    data.put(234567, 765432);
    return data;
  }

}
