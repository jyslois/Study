import java.util.ArrayList;
import java.util.Scanner;

public class ReversedPrimeNumber2 {
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
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int tmp = numbers[i];
            int res = 0; // 뒤집힌 결과
            while (tmp > 0) {
                int t = tmp % 10; // 일의 자리 숫자
                res = res * 10 + t;
                tmp = tmp / 10;
            }
            if (isPrime(res)) {
                answer.add(res);
            }
        }

        return answer;
    }
}
