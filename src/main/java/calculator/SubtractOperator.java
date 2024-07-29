package calculator;

public class SubtractOperator<T extends Number> implements Operator<T> {
    @Override
    public double operate(T firstNumber,T secondNumber){
      return  (double)firstNumber - (double)secondNumber;
    }
}
