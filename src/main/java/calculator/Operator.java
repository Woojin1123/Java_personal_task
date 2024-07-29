package calculator;

public interface Operator<T extends Number> { // Generic 매개변수 T지정
  double operate(T firstNumber, T secondNumber);// 새로운 연산이 추가되더라도 Operator를 상속해서 구현하면 Calculator에서는 변화없음
}
