import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
에라토스테네스의 체는 소수를 찾는 방법이다.
2부터 소수를 구하고자 하는 구간의 모든 수를 나열한다.
2는 소수이므로 오른쪽에 2를 쓴다.
자기 자신을 제외한 2의 배수를 모두 지운다.
남아있는 수 가운데 3은 소수이므로 오른쪽에 3을 쓴다.
자기 자신을 제외한 3의 배수를 모두 지운다.
남아있는 수 가운데 5는 소수이므로 오른쪽에 5를 쓴다.
자기 자신을 제외한 5의 배수를 모두 지운다.
남아있는 수 가운데 7은 소수이므로 오른쪽에 7을 쓴다.
자기 자신을 제외한 7의 배수를 모두 지운다.
위의 과정을 반복하면 구하는 구간의 모든 소수가 남는다.
 */

/*
설명
자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
만약 20이 입력되면 1부터 20까지의 소수는
2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.

입력
첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.

출력
첫 줄에 소수의 개수를 출력합니다.
 */

public class PrimeNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());

        System.out.print(solution(number));
    }

    public static int solution(int number) {
        int answer = 0;

        // number + 1까지 해야 인덱스 번호가 0부터 number까지 생긴다.
        // 이때 배열의 자료들은 모두 0으로 초기화된다.
        int[] list = new int[number + 1];

        // 0과 1은 소수가 아니기 때문에, 2부터 number까지 돈다.
        for (int i = 2; i <= number; i++) {
            if (list[i] == 0) {
                answer++;
                // i의 배수 인덱스들의 값을 모두 1로 초기화한다.
                // j는 i씩 증가한다 = j는 i의 배수이다.
                for (int j = i; j <= number; j = j + i) {
                    list[j] = 1;
                }
            }
        }
        return answer;
    }
}
