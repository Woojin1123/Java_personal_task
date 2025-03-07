package calculator;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator<Double> ac = new ArithmeticCalculator<>(); //인스턴스 생성 시 <Double> 로 타입을 지정
        CircleCalculator cc = new CircleCalculator();
        while(true) { //while(true)를 이용해 break전까지 무한반복
            try {
                System.out.println("사칙연산 1 | 원의 넓이 계산 2 (숫자 입력)");
                int feature = sc.nextInt();
                if(feature > 2) {
                    throw new IllegalArgumentException("1과 2중에 입력해주세요");
                }

                if(feature == 1) {
                    System.out.println("숫자 연산자 숫자 순으로 입력하세요.(입력값 공백으로 구분) "); // 입력 한번에 받음
                    double firstNumber = sc.nextInt();
                    char opChar = sc.next().charAt(0);//sc.next()로 문자열을 받은 후 0번째 char를 가져옴
                    double secondNumber = sc.nextInt();
                    double result = ac.calculate(firstNumber, secondNumber, opChar);//인스턴스 생성시 타입 변수를 Double로 지정했기 때문에 매개변수로 double타입 실수 입력받음
                    ac.getResults().add(result); // calculator 클래스 안의 컬렉션에 저장
                    System.out.printf("%.4f %c %.4f 결과 : %.4f\n", firstNumber, opChar, secondNumber,
                        result);
                    System.out.println("remove 0번째 결과 삭제 | inquiry 결과 값 조회 | lambda 입력 값 보다 큰 결과 조회 (exit 입력 시 종료)");
                    String func = sc.next(); // sc.next()로 비교하면 입력 버퍼의 문자열이 사라지므로 String에 담아서 입력값 확인
                    if (func.equals("exit")) {
                        break;
                    } else if (func.equals("remove")) {
                        ac.removeResults();//removeResults 메소드를 이용해 삭제 수행
                    } else if (func.equals("inquiry")) { // inquiry 기능 구현
                        ac.inquiryResults(); // Calculator클래스의 inquiryResults 메소드를 이용해 결과 출력
                    } else if (func.equals("lambda")){
                        System.out.println("숫자를 입력하세요");
                        ac.lambdaResults(sc.nextDouble());
                    }
                    sc.nextLine(); // 다음 반복문을 위해 스캐너 비워줌
                } else if(feature == 2){ // 2입력시 원의 넓이 구하기 수행
                    System.out.println("원의 반지름을 입력하세요");
                    int radius = sc.nextInt();
                    cc.getResults().add(cc.calculate(radius)); // 원의 넓이 저장
                    cc.inquiryResults(); // 결과 조회
                    System.out.println("exit 입력 시 종료");
                    String func = sc.next();
                    if (func.equals("exit")) {
                        break;
                    }
                    sc.nextLine(); // 다음 반복문을 위해 스캐너 비워줌
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());//e.getmessage()를 이용해 throw한 예외의 오류메세지 출력
                if(sc.hasNextLine()) { //입력존재하면 비우기
                    sc.nextLine();
                }
            }//try-catch문 활용해서 예외 처리
        }
    }
}
