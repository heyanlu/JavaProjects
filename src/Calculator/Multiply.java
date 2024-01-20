package Calculator;

public class Multiply implements Operate {
  public Multiply() {
  }

  public Double getResult(Double... numbers) {
    Double result = 1.0;
    Double[] var3 = numbers;
    int var4 = numbers.length;

    for(int var5 = 0; var5 < var4; ++var5) {
      Double num = var3[var5];
      result = result * num;
    }

    return result;
  }
}
