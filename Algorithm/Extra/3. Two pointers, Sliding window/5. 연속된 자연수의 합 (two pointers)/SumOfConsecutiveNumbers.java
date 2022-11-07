/*
설명
N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로
정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
만약 N=15이면 7+8=15, 4+5+6=15, 1+2+3+4+5=15 와 같이
총 3가지의 경우가 존재한다.

입력
첫 번째 줄에 양의 정수 N(7<=N<1000)이 주어집니다.

출력
첫 줄에 총 경우수를 출력합니다.
 */

import java.io.*;

public class SumOfConsecutiveNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(solution(N)));

        br.close();
        bw.close();
    }

    public static int solution(int N) {
        int answer = 0, sum = 0, lt = 0;
        // 연속되는 자연수이기 때문에 N/2 + 1까지만 있으면 된다.
        int m = N/2 + 1;
        int[] num = new int[m];

        // 인덱스 0부터 m-1까지 : 값은 인덱스+1로 초기화
        for (int i = 0; i < m; i++) {
            num[i] = i + 1;
        }

        for (int rt = 0; rt < m; rt++) {
            sum += num[rt];

            if (sum == N) {
                answer++;
            }

            while (sum >= N) {
                sum -= num[lt++];
                    if (sum == N) {
                        answer++;
                    }
            }
        }

        return answer;
    }
}
