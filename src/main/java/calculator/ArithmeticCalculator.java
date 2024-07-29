package calculator;

public class ArithmeticCalculator extends Calculator {//Calculator상속
  public void removeResults(){ //remove는 사칙연산에서만 수행하기 때문에 이동
    getResults().remove(0); // 상속받았기 때문에 getResults로 간접접근
  }
  public void inquiryResults(){ // results를 조회하는 메소드 상속받아 구현
    System.out.println("사칙 연산 결과");
    for(double i : getResults()){ // results 컬렉션을 순회하면서 출력
      System.out.printf("%.2f ",i);
    }
    System.out.println();
  }
  public Operator makeOp(char opChar){
    OperatorType operatorType = OperatorType.fromOperator(opChar); //반환된 상수로 operatorType 초기화
    return switch (operatorType){ //연산 기호에 따라 Operator 인스턴스 생성
      case ADD -> new AddOperator(); // 상수에 따라 Operator생성
      case SUB -> new SubtractOperator();
      case DIV -> new DivideOperator();
      case MUL -> new MultiplyOperator();
      case MOD -> new ModOperator();
    };
  }
  public double calculate(int firstNumber, int secondNumber, char opChar) {
    return makeOp(opChar).operate(firstNumber,secondNumber);// calculate는 연산기호가 추가되는것에 상관없이 operate만 수행
  }
}
