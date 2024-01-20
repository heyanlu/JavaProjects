package Calculator;

public class Subtract implements Operate {
  public Subtract() {
  }

  public Double getResult(Double... numbers) {
    Double result = numbers[0];

    for(int i = 0; i < numbers.length; ++i) {
      result = result - numbers[i];
    }

    return result;
  }
}

