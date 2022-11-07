/*
문제
어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다.
등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다.
N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를
출력하는 프로그램을 작성하시오.

입력
첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.

출력
첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.
 */

import java.io.*;

public class ArithmeticSequence_1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int N = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(countHan(N)));

        bw.flush();

        br.close();
        bw.close();

    }

    public static int countHan(int N) {
        int count = 0;

        // 한자리 수, 두 자리 수는 모두 한수이다.
        // 예를 들면 91을 입력 받았다고 하면, 1~91까지 모두 한수이다.
        // 따라서 N이 한자리나 두자리 수이면, 1부터 N까지 N개의 한수가 있다.
        if (N < 100) {
            return N;
        } else {
            // N이 세자리 수일 경우
            // 100전까지, 일단 99까지는 99개의 한수가 있으므로 카운트를 99로 초기화한다
            count = 99;

            // 100부터 N까지 돌면서 한수인지 체크해서 한수이면 카운트++
            for (int i = 100; i <= N; i++) {
                int a = i % 10; // 일의 자리
                int b = i / 10 % 10; // 십의 자리
                int c = i / 100; // 백의 자리

                if (c - b == b - a) {
                    count++;
                }
            }
        }

        return count;
    }
}
