/*
설명

N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면
그 소수를 출력하는 프로그램을 작성하세요.
예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다.
단 910를 뒤집으면 19로 숫자화 해야 한다.
첫 자리부터의 연속된 0은 무시한다.

입력
첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고,
그 다음 줄에 N개의 자연수가 주어진다.
각 자연수의 크기는 100,000를 넘지 않는다.

출력
첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class ReversedPrimeNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scan.nextInt();
        }

        for (int x : solution(n, numbers)) {
            System.out.print(x + " ");
        }
    }

    // N이 소수인지 확인해 보는 방법은 다음과 같다.
    // 2 이상 N보다 작은 자연수들로 모두 나누어서, 만약 나누어 떨어지는 수가
    // 없다면 소수이다.
    public static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                // i는 num의 약수이다. 즉, num은 소수가 아닌 합성수이다.
                return false;
            }
        }

        return true;
    }

    public static ArrayList<Integer> solution(int n, int[] numbers) {
        int[] reversed = new int[n];
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            reversed[i] = Integer.valueOf(new StringBuilder(String.valueOf(numbers[i])).reverse().toString());
            if (isPrime(reversed[i])) {
                answer.add(reversed[i]);
            }
        }

        return answer;
    }
}
