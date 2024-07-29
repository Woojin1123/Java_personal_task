package calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calcInstance = new Calculator(); // Calculator 생성자를 통해 results가 초기화됨

        while(true) { //while(true)를 이용해 break전까지 무한반복
            try {
                System.out.println("사칙연산 1 | 원의 넓이 계산 2 (숫자 입력)");
                int feature = sc.nextInt();
                if(feature > 2) {
                    throw new IllegalArgumentException("1과 2중에 입력해주세요");
                }

                if(feature == 1) {
                    System.out.println("숫자 연산자 숫자 순으로 입력하세요.(입력값 공백으로 구분) "); // 입력 한번에 받음
                    int firstNumber = sc.nextInt(); //nextInt로 숫자 받아서 초기화
                    char operator = sc.next().charAt(0);//sc.next()로 문자열을 받은 후 0번째 char를 가져옴
                    int secondNumber = sc.nextInt();
                        int result = calcInstance.calculate(firstNumber, secondNumber,
                            operator);//정수, 연산 기호를 인자로 넘겨서 calculate 메소드 호출
                        System.out.printf("%d %c %d 결과 : %d\n", firstNumber, operator, secondNumber,
                            result);
                        System.out.println("remove 0번째 결과 삭제 | inquiry 결과 값 조회 (exit 입력 시 종료)");
                        String func = sc.next(); // sc.next()로 비교하면 입력 버퍼의 문자열이 사라지므로 String에 담아서 입력값 확인
                        if (func.equals("exit")) {
                            break;
                        } else if (func.equals("remove")) {
                            calcInstance.removeResults();//removeResults 메소드를 이용해 삭제 수행
                        } else if (func.equals("inquiry")) { // inquiry 기능 구현
                            calcInstance.inquiryResults(); // Calculator클래스의 inquiryResults 메소드를 이용해 결과 출력
                        }
                        sc.nextLine(); // 다음 반복문을 위해 스캐너 비워줌
                } else if(feature == 2){ // 2입력시 원의 넓이 구하기 수행
                    System.out.println("원의 반지름을 입력하세요");
                    int radius = sc.nextInt();
                    calcInstance.getAreaResults().add(calcInstance.calculateCircle(radius)); // 원의 넓이 저장
                    calcInstance.inquiryAreaResults(); // 결과 조회
                    System.out.println("exit 입력 시 종료");
                    String func = sc.next();
                    if (func.equals("exit")) {
                        break;
                    }
                    sc.nextLine(); // 다음 반복문을 위해 스캐너 비워줌
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());//e.getmessage()를 이용해 throw한 예외의 오류메세지 출력
            }//try-catch문 활용해서 예외 처리
        }
    }
}
