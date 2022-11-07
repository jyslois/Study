/*
설명
5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.
(이미지)
N*N의 격자판이 주어지면 각 행의 합, 각 열의 합,
두 대각선의 합 중 가 장 큰 합을 출력합니다.

입력
첫 줄에 자연수 N이 주어진다.(2<=N<=50)
두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다.
각 자연수는 100을 넘지 않는다.

출력
최대합을 출력합니다.
 */

import java.io.*;

public class GridGreatestSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        // 정수형을 Buffered Writer에 넣고 싶으면, String형으로의 변환이 필요하다.
        bw.write(String.valueOf(solution(n, grid)));
        bw.flush();

        bw.close();
        br.close();

    }

    public static int solution(int n, int[][] grid) {
        int sum1, sum2;
        int answer = Integer.MIN_VALUE;

        // 각 행과 열의 합 중 가장 큰 수
        for (int i = 0; i < n; i++) {
            sum1 = sum2 = 0;
            for (int j = 0; j < n; j++) {
                sum1 += grid[i][j]; // 각 행의 합
                sum2 += grid[j][i]; // 각 열의 합
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }

        // 각 대각선의 합 중 가장 큰 수
        sum1 = sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += grid[i][i];
            sum2 += grid[i][n-1-i];
        }
        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);

        return answer;
    }
}
