/*
설명
N개의 수로 이루어진 수열이 주어집니다.
이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지
구하는 프로그램을 작성하세요.
만약 N=8, M=6이고 수열이 다음과 같다면
1 2 1 3 1 1 1 2
합이 6이 되는 연속부분수열은
{2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.

입력
첫째 줄에 N(1≤N≤100,000), M(1≤M≤100,000,000)이 주어진다.
수열의 원소값은 1,000을 넘지 않는 자연수이다.

출력
첫째 줄에 경우의 수를 출력한다.
 */

import java.io.*;
import java.util.StringTokenizer;

public class PartialContinuousSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        final int N = Integer.parseInt(input[0]);
        final int M = Integer.parseInt(input[1]);

        int[] seq = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(String.valueOf(solution(N, M, seq)));

        br.close();
        bw.close();
    }

//    // 기초적인 접근 방법: 시간 복잡도 O(N2): 이중 for문이기 때문
//    // N과 M의 값이 크기 때문에 O(N2)은 비효율적이다 (input크기를 보면 이중 for문이 비효율적이라는 걸 알 수 있음)
//    public static int solution(int N, int M, int[] seq) {
//        int answer = 0;
//
//        for (int i = 0; i < N; i++) {
//            int sum = 0;
//            for (int j = i; j < N; j++) {
//                sum += seq[j];
//                if (sum == M) {
//                    answer++;
//                    break;
//                }
//            }
//        }
//
//        return answer;
//    }


    // two-pointer algorithm 과 sliding window를 사용하면 O(n)로 해결 가능.
    public static int solution(int N, int M, int[] seq) {
        int answer = 0;
        // two pointers algorithm: lt~rt의 합이 M이 되는가
        int lt = 0;
        int sum = 0;

        // 1) sum이 M보다 작으면 ++rt 후 sum에 누적해서 M과 비교
        // 2) sum이 M과 같으면 count++ 후 sum-lt하고 (lt++한 후) M과 비교
        // 3) sum이 M보다 크면 sum-lt하고 (lt++ 한 후) M과 비교

        for (int rt = 0; rt < N; rt++) {
            sum += seq[rt];

            if (sum == M) {
                answer++;
            }

            while (sum >= M) { // sum이 M보다 크거나 같을 경우 반복
               sum-= seq[lt++];
                    if (sum == M) {
                        answer++;
                    }
            }
            // 여기까지 오면 무조건 sum이 M보다 작음
        }

        return answer;

    }


}
