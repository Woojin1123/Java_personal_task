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
  public double calculate(int firstNumber, int secondNumber, char operator)
      throws ArithmeticException, IllegalArgumentException {//매개변수로 양의 정수 2개 연산 기호를 받음 , throws를 활용해서 main에서 예외처리
    double result = 0;
    switch (operator) { //main의 switch문 활용해서 구현
      case '+' -> result = firstNumber + secondNumber;
      case '-' -> result = firstNumber - secondNumber;
      case '/' -> {
        if (secondNumber == 0) { // 두번째 숫자가 0일 경우 ArithmeticException throw
          throw new ArithmeticException("나눗셈 연산에서 분모에는 0이 올 수 없습니다.");
        } else {
          result = (double)firstNumber / secondNumber; // 저장결과 타입이 double로 바뀌었기 때문에 double로 형변환해서 계산
        }
      }
      case '*' -> result = firstNumber * secondNumber;
      default -> throw new IllegalArgumentException("연산 기호가 잘못되었습니다.");//연산기호가 잘못됬을 경우 IllegalArgumentException throw
    }
    getResults().add(result); // calculator 클래스 안의 컬렉션에 저장
    return result;
  }
}
