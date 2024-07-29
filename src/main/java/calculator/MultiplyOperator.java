package calculator;

public class MultiplyOperator<T extends Number> implements Operator<T> {
  @Override
  public double operate(T firstNumber,T secondNumber){
    return  (double)firstNumber * (double)secondNumber;
  }

}
