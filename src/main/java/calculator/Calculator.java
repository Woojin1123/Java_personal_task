package calculator;

import java.util.ArrayList;

public class Calculator {

  private ArrayList<Integer> results = new ArrayList<>(); //접근제어자 private를 통해 클래스 내부에서만 접근 가능하도록 함
  public ArrayList<Integer> getResults() { // getResults() 메소드를 통해 외부에서 results에 접근할 수 있게 함
    return results;
  }
  public void setResults(ArrayList<Integer> result) { //setResults()메소드를 이용해 results 수정할 수 있게 함
    this.results = result;
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
}
