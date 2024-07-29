package calculator;

import java.util.stream.Stream;
import org.w3c.dom.ls.LSOutput;

public class ArithmeticCalculator<T extends Number> extends Calculator {//Number타입의 자손 즉, Float,Double,Integer 등 숫자만 가능하게함, 인스턴스 생성 시 타입을 타입 변수 <T>에 명시
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
  public void lambdaResults(T num){
//    System.out.print(num + " 보다 큰 결과값 : ");
//    for(double d : getResults()){
//      if(d>(double)num){
//        System.out.printf("%.2f ",d);
//      }
//    }
//    System.out.println();
    System.out.print(num + " 보다 큰 결과값 : ");
    getResults().stream() // results ArrayList로 스트림생성
        .filter( d -> d > num.doubleValue()) // 람다식을 이용해 d>num일때 결과값 필터링
        .forEach(d -> System.out.printf("%.2f ", d)); //걸러진 d값 출력
    System.out.println();
  }
}
