/*
N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.
같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.

입력 첫 줄에 N(3<=N<=100)이 입력되고, 두 번째 줄에 국어점수를 의미하는 N개의 정수가 입력된다.
출력 입력된 순서대로 등수를 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindingRank {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] scores = br.readLine().split(" ");
        for (int x : solution(n, scores)) {
            System.out.print(x + " ");
        }
    }

    public static int[] solution(int n, String[] scores) {
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            // 1등으로 초기화
            rank[i] = 1;
            // 만약 기준 점수가 다른 점수보다 작다면, 등수 1증가
            for (int j = 0; j < n; j++) {
                if (Integer.parseInt(scores[i]) < Integer.parseInt(scores[j])) {
                    rank[i]++;
                }
            }
        }

        return rank;
    }
}
