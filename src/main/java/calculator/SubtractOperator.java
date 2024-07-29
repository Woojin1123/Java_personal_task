package calculator;

public class SubtractOperator implements Operator {
    @Override
    public double operate(int firstNumber,int secondNumber){
      return  firstNumber - secondNumber;
    }
}
