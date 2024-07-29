package calculator;

import java.util.ArrayList;

public class Calculator {
  static final double PI = 3.14; //원주율은 변하지 않는 상수이기 때문에 final로 선언, static으로 선언해 모든 calculator 인스턴스가 동일한 PI를 사용하게 되어 메모리 절약
  private ArrayList<Integer> results; //생성자를 통해 초기화 하기 위해 선언만 해줌
  private ArrayList<Double> areaResults; // 원의 넓이를 저장할 컬렉션 areaResults선언
  Calculator(){ // Calculator 클래스 생성자
    results = new ArrayList<>(); // 생성자 통해 results초기화
    areaResults = new ArrayList<>(); // areaResult초기화
  }
  public ArrayList<Integer> getResults() { // getResults() 메소드를 통해 외부에서 results에 접근할 수 있게 함
    return this.results;
  }
  public void setResults(ArrayList<Integer> result) { //setResults()메소드를 이용해 results 수정할 수 있게 함
    this.results = result;
  }

  public void setAreaResults(ArrayList<Double> areaResults) { // areaResult Setter 구현
    this.areaResults = areaResults;
  }
  public ArrayList<Double> getAreaResults(){ // areaResult Getter구현
    return this.areaResults;
  }

  public void removeResults(){ // 반환타입이 없기 때문에 void로 선언
    this.results.remove(0); // 메소드 호출시 index 0번째의 값 삭제
  }
  public void inquiryResults(){ // results를 조회하는 메소드
    for(int i : this.results){ // results 컬렉션을 순회하면서 출력
      System.out.printf("%d ",i);
    }
    System.out.println();
  }
  public int calculate(int firstNumber, int secondNumber, char operator)
      throws ArithmeticException, IllegalArgumentException {//매개변수로 양의 정수 2개 연산 기호를 받음 , throws를 활용해서 main에서 예외처리
    int result = 0;
    switch (operator) { //main의 switch문 활용해서 구현
      case '+' -> result = firstNumber + secondNumber;
      case '-' -> result = firstNumber - secondNumber;
      case '/' -> {
        if (secondNumber == 0) { // 두번째 숫자가 0일 경우 ArithmeticException throw
          throw new ArithmeticException("나눗셈 연산에서 분모에는 0이 올 수 없습니다.");
        } else {
          result = firstNumber / secondNumber;
        }
      }
      case '*' -> result = firstNumber * secondNumber;
      default -> throw new IllegalArgumentException("연산 기호가 잘못되었습니다.");//연산기호가 잘못됬을 경우 IllegalArgumentException throw
    }
    this.results.add(result); // calculator 클래스 안의 컬렉션에 저장
    return result;
  }
  public void inquiryAreaResults(){ // arearesults를 조회하는 메소드
    for(double i : this.areaResults){ // arearesults 컬렉션을 순회하면서 출력
      System.out.printf("%.2f ",i);
    }
    System.out.println();
  }
  public double calculateCircle(int radius){ //원의 넓이를 계산해주는 메소드
    return PI * radius * radius;
  }
}
