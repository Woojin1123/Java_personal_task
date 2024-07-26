package calculator;

import java.sql.SQLOutput;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        int[] results = new int[10]; // int형 배열 선언 후 size 10 으로 초기화
        int index = 0; // 위치를 저장할 index

        while(true) { //while(true)를 이용해 break전까지 무한반복
            System.out.println("숫자 연산자 숫자 순으로 입력하세요.(입력값 공백으로 구분) "); // 입력 한번에 받음
            int firstNumber = sc.nextInt(); //nextInt로 숫자 받아서 초기화
            char operator = sc.next().charAt(0);//sc.next()로 문자열을 받은 후 0번째 char를 가져옴
            int secondNumber = sc.nextInt();
            try {
                switch (operator) { //개선된 switch문을 활용해 연산기호를 받아 알맞은 연산 실행
                    case '+' -> result = firstNumber + secondNumber;
                    case '-' -> result = firstNumber - secondNumber;
                    case '/' -> {
                        if (secondNumber == 0) { // 두번째 정수가 0이면 오류메세지 출력
                            throw new ArithmeticException(
                                "나눗셈 연산에서 분모에는 0이 올 수 없습니다."); // Exception 생성자를 이용해 오류메세지와 함께 예외 던짐
                        } else {
                            result = firstNumber / secondNumber;
                        }
                    }
                    case '*' -> result = firstNumber * secondNumber;
                }
                System.out.printf("%d %c %d 결과 : %d\n", firstNumber, operator, secondNumber, result);
                results[index] = result; // 계산 결과를 results 의 index번째에 저장
                index++;// 다음 저장 위치로 이동
                if(index == 10){ //배열이 꽉 찼을 경우
                    for(int i = 0; i<9; i++){
                        results[i] = results[i+1]; // 한칸씩 앞으로 당겨옴
                    }
                    index = 9; // index를 배열의 마지막 위치를 가리키도록 바꿔 새로 저장 가능하게 함
                }
                for(int i : results) { // foreach문을 활용해 results 내용 출력
                    System.out.printf("%d ",i);
                }
                System.out.println();
                System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                if(sc.next().equals("exit")){break;} // sc.next()로 입력버퍼에 존재하는 문자열 받아온 후 String의 equals메소드로 exit와 값 비교
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());//e.getmessage()를 이용해 throw한 예외의 오류메세지 출력
            } //try-catch문 활용해서 예외 처리
        }
    }
}
