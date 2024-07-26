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
        System.out.printf("%d %d",firstNumber,secondNumber);
    }
}
