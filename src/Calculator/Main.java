package Calculator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  public Main() {
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    label49:
    while(true) {
      System.out.println("Enter expression (type 'q' to quit): ");
      String input = scanner.nextLine();
      if (input.equalsIgnoreCase("q")) {
        scanner.close();
        return;
      }

      String[] numberArray = input.split("[-+*/]");
      String[] operArray = input.split("[0-9]+");
      Queue<String> numbers = new LinkedList(Arrays.asList(numberArray));
      Queue<String> operations = new LinkedList(Arrays.asList(operArray));
      Double res = Double.parseDouble((String)numbers.poll());

      while(true) {
        Object operate;
        label44:
        while(true) {
          if (numbers.isEmpty()) {
            System.out.println("Result: " + res);
            continue label49;
          }

          String opr = (String)operations.poll();
          operate = null;
          switch (opr) {
            case "+":
              operate = new Add();
              break label44;
            case "-":
              operate = new Subtract();
              break label44;
            case "*":
              operate = new Multiply();
              break label44;
            case "/":
              operate = new Divide();
              break label44;
          }
        }

        Double num = Double.parseDouble((String)numbers.poll());
        res = ((Operate)operate).getResult(new Double[]{res, num});
      }
    }
  }
}

