package calculator;

public class DivideOperator<T extends Number> implements Operator<T> {
  @Override
  public double operate(T firstNumber,T secondNumber) throws ArithmeticException {
    if((double)secondNumber == 0.0){
      throw new ArithmeticException("분모에는 0이 올 수 없습니다.");
    }
    return  (double)firstNumber / (double)secondNumber;
  }
}
