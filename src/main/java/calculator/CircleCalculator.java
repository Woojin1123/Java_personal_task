package calculator;

public class CircleCalculator extends Calculator { //Calculator상속
  static final double PI = 3.14; //PI는 원의 넓이 계산에서만 사용
  public double calculate(int radius){ //원의 넓이를 계산해주는 메소드
    return PI * radius * radius;
  }

  @Override
  public void inquiryResults() {
    System.out.println("원의 넓이 결과");
    for(double i : getResults()){ // results 컬렉션을 순회하면서 출력
      System.out.printf("%.2f ",i);
    }
    System.out.println();
  }
}
