/*
한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진
최소거리를 출력하는 프로그램을 작성하세요.

입력 첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
문자열의 길이는 100을 넘지 않는다.
출력 첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
 */

import java.util.Scanner;

public class ShortestDistance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String sen = scan.next();
        char ch = scan.next().charAt(0);

        for (int x : solution(sen, ch)) {
            System.out.print(x + " ");
        }
    }

    public static int[] solution(String sen, char ch) {
        int[] answer = new int[sen.length()];

        int dis = 1000;

        // 왼쪽에 있는 문자 ch로부터의 거리 (왼쪽에서 오른쪽)
        for (int i = 0; i < sen.length(); i++) {
            if (sen.charAt(i) == ch) {
               dis = 0;
            } else {
                dis++;
            }
            answer[i] = dis;
        }
        // 1001 0 1 2 3 0 1 2 3 4 0

        // 오른쪽에 있는 문자 ch로부터의 거리 (오른쪽에서 왼쪽)
        dis = 1000;

        for (int i = sen.length() - 1; i >= 0; i--) {
            if (sen.charAt(i) == ch) {
                dis = 0;
            } else {
                dis++;
                // 오른쪽 왼쪽 비교해서 더 작은 거리를 answer에 넣어 교체
            }
            answer[i] = Math.min(answer[i], dis);
        }

        return answer;
    }

}
