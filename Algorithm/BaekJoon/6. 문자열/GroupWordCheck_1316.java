/*
문제
그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각
문자가 연속해서 나타나는 경우만을 말한다.
예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고,
kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만,
aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는
프로그램을 작성하시오.

입력
첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다.
둘째 줄부터 N개의 줄에 단어가 들어온다. 단어는 알파벳 소문자로만 되어있고
중복되지 않으며, 길이는 최대 100이다.

출력
첫째 줄에 그룹 단어의 개수를 출력한다.
 */

import java.io.*;

public class GroupWordCheck_1316 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (check(word)) { // true일 경우에만 count++
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean check(String word) {
        boolean[] check = new boolean[26];  // 알파벳 26개
        // a가 97이고 0번 인덱스에 와야 하니까, 알파벳 - 97(- 'a')을 해 주어야 한다.
        // false 기본값으로 초기화돼 있다.

        int prev = 0;

        for (int i = 0; i < word.length(); i++) {
            int now = word.charAt(i); // i 번째 문자 저장 (현재 문자)

            // 앞선 문자와 i 번째 문자가 같지 않다면
            if (prev != now) {
                // 해당 문자가 처음 나오는 경우 (false인 경우 - !false => true)
                // if (check[now-'a']==false)
                if (!check[now - 'a']) { // now - 97
                    // true로 바꿔준다
                    check[now - 'a'] = true;
                    // 다음 턴을 위해 prev로 바꿔 준다
                    prev = now; // 만약 now가 a인 경우 97이 prev에 저장('a'=97)
                } else {
                    // 해당 문자가 이미 나온 적 있는 경우 (true인 경우)
                    // 즉. 그룹단위가 아니게 될 경우
                    return false; // false를 return 하고 함수 종료
                }
            }
            // prev와 now가 같다면 그냥 통과
        }

        return true;
    }

}
