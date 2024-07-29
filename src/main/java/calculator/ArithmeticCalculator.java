package calculator;
//2. 지금까지는 ArithmeticCalculator, 즉 사칙연산 계산기는 양의 정수(0 포함)를 매개변수로 전달받아 연산을 수행했습니다.
//    - 이제부터는 양의 정수 뿐만 아니라 실수, 즉 double 타입의 값을 전달 받았을 경우에도 연산이 수행되도록, 즉 피연산자를 여러 타입으로 받을 수 있도록 기능을 확장하고 싶습니다.
//    - ArithmeticCalculator 클래스의 연산 메서드(`calculate`)
//    - 위 요구사항을 만족할 수 있도록 ArithmeticCalculator 클래스를 수정합니다. (제네릭스)
//    - 추가적으로 수정이 필요한 다른 클래스나 메서드가 있다면 같이 수정 해주세요.
public class ArithmeticCalculator<T extends Number> extends Calculator {//Number타입의 자손 즉, Float,Double,Integer 등 숫자만 가능하게함, 인스턴스 생성 시 타입을 매개변수 T로 명시
  private Operator<T> op;
  public Operator<T> getOp() {
    return this.op;
  } //Operator를 사칙연산에서만 사용하기 때문에 arithmetic 클래스로 이동
  public void setOp(Operator<T> op){
    this.op = op;
  }

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
  public Operator<T> makeOp(char opChar){ //Operator<Double>
    OperatorType operatorType = OperatorType.fromOperator(opChar); //반환된 상수로 operatorType 초기화
    return switch (operatorType){ //연산 기호에 따라 Operator 인스턴스 생성
      case ADD -> new AddOperator<>(); // 상수에 따라 Operator생성
      case SUB -> new SubtractOperator<>();
      case DIV -> new DivideOperator<>();
      case MUL -> new MultiplyOperator<>();
      case MOD -> new ModOperator<>();
    };
  }
  public double calculate(T firstNumber, T secondNumber, char opChar) { //T타입이 App.java에서 지정한 타입으로 변경, 제네릭으로 선언되었기 때문에 App.java에서 입력될 타입을 지정하면 다른 클래스의 타입을 변경하지 않아도 됨.
    return makeOp(opChar).operate(firstNumber,secondNumber);// calculate는 연산기호가 추가되는것에 상관없이 operate만 수행
  }
}
