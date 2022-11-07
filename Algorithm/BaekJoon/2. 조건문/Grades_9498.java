/*
문제
시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B, 70 ~ 79점은 C,
60 ~ 69점은 D, 나머지 점수는 F를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 시험 점수가 주어진다. 시험 점수는 0보다 크거나 같고,
100보다 작거나 같은 정수이다.

출력
시험 성적을 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Grades_9498 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int grade = Integer.parseInt(br.readLine());

        switch (grade / 10) {
            // 다중 케이스 라벨
            // 화살표 case 라벨 -> 을 사용하여 break문 대체가 가능하지만,
            // 실행문이 2개 이상일 때는 중괄호로 묶어주어야 한다.
            case 10, 9 -> {
                System.out.println("A");
                System.out.println("잘했습니다.");
            }
            case 8 -> System.out.println("B");
            case 7 -> System.out.println("C");
            case 6 -> System.out.println("D");
            default -> System.out.println("F");
        }

    }
}
