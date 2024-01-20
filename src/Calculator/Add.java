package Calculator;

public class Add implements Operate {
  public Add() {
  }

  public Double getResult(Double... numbers) {
    Double sum = 0.0;
    Double[] var3 = numbers;
    int var4 = numbers.length;

    for(int var5 = 0; var5 < var4; ++var5) {
      Double num = var3[var5];
      sum = sum + num;
    }

    return sum;
  }
}

