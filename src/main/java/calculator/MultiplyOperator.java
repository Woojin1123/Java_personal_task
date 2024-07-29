package calculator;

public class MultiplyOperator {
  public double operate(int firstNumber,int secondNumber){
    return  (double)firstNumber * secondNumber; //오버플로우 방지
  }

}
