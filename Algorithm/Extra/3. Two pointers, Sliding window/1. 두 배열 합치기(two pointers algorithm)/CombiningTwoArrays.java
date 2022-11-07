/*
설명
오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을
오름차순으로 합쳐 출력하는 프로그램을 작성하세요.

입력
첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.

출력
오름차순으로 정렬된 배열을 출력합니다.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CombiningTwoArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        for (int x : solution(n, a, m, b)) {
            bw.write(x + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static ArrayList<Integer> solution(int n, int[] a, int m, int[] b) {
        ArrayList<Integer> answer = new ArrayList<>();

        // 정렬만 해도 o(nlogn)이다.
        // 투 포인터 알고리즘: p1은 배열 a의 인덱스, p2는 배열 b의 인덱스
        // 만약 a[p1] < b[p2] 이면, answer에다가 a[p1]을 추가한다. 작은 쪽을 추가.
        // 그리고 넣은 쪽의 포인터를 1 증가시킨다. p1++
        // p1 < n, p2 < m. 누구 하나가 끝으로 가면 멈추게 하기.
        // 그때 다른 하나가 안 끝났으면 그냥 남은 쪽을 다 answer에 넣기.
        int p1 = 0, p2 = 0;
        while (p1 < n && p2 < m) {
            if (a[p1] < b[p2]) {
                answer.add(a[p1++]);
            } else {
                answer.add(b[p2++]);
            }
        }
        while (p1 < n) {
            answer.add(a[p1++]);
        }
        while (p2 < m) {
            answer.add(b[p2++]);
        }

        return answer;
    }
}
