package calculator;

public class DivideOperator implements Operator {
  @Override
  public double operate(int firstNumber,int secondNumber){
    return  (double)firstNumber / secondNumber;
  }
}
