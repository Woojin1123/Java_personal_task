package calculator;

public class DivideOperator implements Operator {
  @Override
  public double operate(int firstNumber,int secondNumber){
    if(secondNumber == 0){
      throw new ArithmeticException("분모에는 0이 올 수 없습니다.");
    }
    return  (double)firstNumber / secondNumber;
  }
}
