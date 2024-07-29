package calculator;

public class AddOperator implements Operator{ // SRP 원칙을 적용해 연산에 따라 클래스로 역할을 나누어 계산 , 변경이 생기면 변경사항에 맞는 연산클래스 수정
  @Override
  public double operate(int firstNumber,int secondNumber){
    return  (double)firstNumber + secondNumber; // 오버플로우 방지
  }
}
