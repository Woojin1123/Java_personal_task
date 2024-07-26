package calculator;

import java.sql.SQLOutput;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요 : ");
        int firstNumber = sc.nextInt(); //nextInt로 숫자 받아서 초기화
        System.out.print("두 번째 숫자를 입력하세요 : ");
        int secondNumber = sc.nextInt();
        System.out.print("사칙연산 기호를 입력하세요 : ");
        char operator = sc.next().charAt(0); //sc.next()로 문자열을 받은 후 0번째 char를 가져옴
        System.out.printf("%d %d %c ",firstNumber,secondNumber,operator);
    }
}
