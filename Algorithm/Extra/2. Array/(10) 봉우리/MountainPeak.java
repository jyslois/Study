/*
설명
지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.
각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다.
봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.
격자의 가장자리는 0으로 초기화 되었다고 가정한다.
만약 N=5 이고, 격자판의 숫자가 다음과 같다면 봉우리의 개수는 10개입니다.
(이미지)

입력
첫 줄에 자연수 N이 주어진다.(2<=N<=50)
두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다.
각 자연수는 100을 넘지 않는다.

출력
봉우리의 개수를 출력하세요.
 */

import java.io.*;
import java.util.StringTokenizer;

public class MountainPeak {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] mountain = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                mountain[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(String.valueOf(solution(n, mountain)));
        bw.flush();

        br.close();
        bw.close();

    }

    public static int solution(int n, int[][] mountain) {
        int answer = 0;

        int[] dx = {-1, 1, 0, 0}; // 행
        int[] dy = {0, 0, -1, 1}; // 열

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                // 네 방향 체크

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    // 바운더리에 대한 조건이 먼저 나와야 바르게 검사된다.
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && mountain[i][j] <= mountain[nx][ny]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    answer++;
                }

            }
        }

        return answer;
    }
}
