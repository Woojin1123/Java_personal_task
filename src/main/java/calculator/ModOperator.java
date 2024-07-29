package calculator;

public class ModOperator implements Operator {
  @Override
  public double operate(int firstNumber,int secondNumber){
    return firstNumber % secondNumber;
  }
}
