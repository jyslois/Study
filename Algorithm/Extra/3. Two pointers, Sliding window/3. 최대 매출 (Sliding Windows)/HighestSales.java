/*
설명
현수의 아빠는 제과점을 운영합니다.
현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이
얼마인지 구하라고 했습니다.

만약 N=10이고 10일 간의 매출기록이 아래와 같습니다.
이때 K=3이면 12 1511 20 2510 20 19 13 15
연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.

여러분이 현수를 도와주세요.


입력
첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.

두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.


출력
첫 줄에 최대 매출액을 출력합니다.
 */

import java.io.*;
import java.util.StringTokenizer;

public class HighestSales {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] num = br.readLine().split(" ");
        int n = Integer.parseInt(num[0]);
        int k = Integer.parseInt(num[1]);

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] sales = new int[n];
        for (int i = 0; i < n; i++) {
            sales[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(String.valueOf(solution(n, k, sales)));

        br.close();
        bw.close();
    }

    public static int solution(int n, int k, int[] sales) {
        int answer = 0, sum = 0;

        // sliding window
        // 첫번째 위도우
        for (int i = 0; i < k; i++) {
            sum += sales[i];
        }
        // answer을 sum으로 초기화
        answer = sum;

        // window 밀기
        for (int i = k; i < n; i++) {
            // sum에 새로운 칸의 값은 더해주고, 저번 윈도우의 첫번재 값은 빼주고.
            sum = sum + sales[i] - sales[i-k];
            // answer와 sum 중에 큰 값을 answer에 저장
            answer = Math.max(answer, sum);
        }

        return answer;
    }
}
