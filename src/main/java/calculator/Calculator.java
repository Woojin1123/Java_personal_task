package calculator;

import java.util.ArrayList;

public class Calculator {

  ArrayList<Integer> results = new ArrayList<>();//연산 결과 저장할 ArrayList 선언 및 초기화

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
    results.add(result);
    return result;
  }
}
