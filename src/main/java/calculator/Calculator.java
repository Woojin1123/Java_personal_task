package calculator;

import java.util.ArrayList;

public abstract class Calculator { //추상클래스로 변경
  private ArrayList<Double> results; //결과값 저장을 위한 컬렉션을 Double타입으로 통일
  AddOperator add;
  SubtractOperator sub;
  DivideOperator div;
  MultiplyOperator mul;
  Calculator(){ // Calculator 클래스 생성자
    results = new ArrayList<>(); // 생성자 통해 results초기화
    add = new AddOperator(); // Calculator클래스의 생성자에서 각 연산클래스의 인스턴스 생성
    sub = new SubtractOperator();
    mul = new MultiplyOperator();
    div = new DivideOperator();
  }
  public ArrayList<Double> getResults() {
    return results;
  }
  public void setResults(ArrayList<Double> results) {
    this.results = results;
  }
  public abstract void inquiryResults(); // 결과 조회 메소드는 사칙연산, 원의 넓이에 모두 존재하기 때문에 추상메소드로 선언 후 상속받아 구현
}
