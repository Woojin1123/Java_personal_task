package calculator;

public interface Operator { // OCP원칙을 지키기 위해 ADD, MOD, MULTIPLY, DIVIDE, SUBTRACT가 Operator인터페이스를 상속하도록 변경
  double operate(int firstNumber, int secondNumber);// 새로운 연산이 추가되더라도 Operator를 상속해서 구현하면 Calculator에서는 변화없음
}
