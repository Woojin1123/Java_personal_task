package calculator;

public class AddOperator<T extends Number> implements Operator<T>{ // SRP 원칙을 적용해 연산에 따라 클래스로 역할을 나누어 계산 , 변경이 생기면 변경사항에 맞는 연산클래스 수정
  @Override
  public double operate(T firstNumber, T secondNumber){ 
    return  (double)firstNumber + (double)secondNumber; //T에 뭐가 올지 모르기 때문에 Number의 하위클래스 중 가장 넓은 범위를 가지는 double로 캐스팅
  }
}
