package Calculator;

public class Divide implements Operate {
  public Divide() {
  }

  public Double getResult(Double... numbers) {
    Double result = numbers[0];

    for(int i = 1; i < numbers.length; ++i) {
      result = result / numbers[i];
    }

    return result;
  }
}
