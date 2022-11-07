/*
문제
알파벳 소문자, 대문자, 숫자 0-9중 하나가 주어졌을 때,
주어진 글자의 아스키 코드값을 출력하는 프로그램을 작성하시오.

입력
알파벳 소문자, 대문자, 숫자 0-9 중 하나가 첫째 줄에 주어진다.

출력
입력으로 주어진 글자의 아스키 코드 값을 출력한다.
 */

import java.util.Scanner;

public class AschiiCode_11654 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // String으로 입력 받아서 문자열을 잘라 문자열로 반환한다
        // int 타입 변수에 저장함으로서 문자에 대응하는 값, 아스키 코드를 저장한다
        // 문자를 아스키 코드로 변환하려면 char을 int로 형변환하면 되는 것이다
       int input = scan.nextLine().charAt(0);

        System.out.println(input);

        // a-z : 97-122
        // A-Z : 65-90
        // '0' = 48

    }
}
