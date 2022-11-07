/*
설명
1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여
다음 숫자가 되는 수열이다.
2) 입력은 피보나치 수열의 총 항의 수 이다.
만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.

입력
첫 줄에 총 항수 N(3<=N<=45)이 입력된다.

출력
첫 줄에 피보나치 수열을 출력합니다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());

        for (int x : solution(number)) {
            System.out.print(x + " ");
        }
    }

    public static int[] solution(int number) {
        int[] answer = new int[number];
        answer[0] = 1;
        answer[1] = 1;

        int first = 1, second = 1;

        for (int i = 2; i < number; i++) {
            answer[i] = first + second;
            first = second;
            second = answer[i];
        }

        // 혹은
//        for(int i = 2; i < number; i++){
//            answer[i] = answer[i-2] + answer[i-1];
//        }

        // 혹은 (손코딩)
//        public void solution(int number) {
//            int a = 1, b = 1, c;
//            System.out.print(a + " " + b + " ");
//            for (int i = 2; i < number; i++) {
//                c = a + b;
//                System.out.print(c + " ");
//                a = b;
//                b = c;
//            }
//        }

        return answer;
    }

}
