import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고,
B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.
가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
두 사람의 각 회의 가위, 바위, 보 정보가 주어지면
각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.
입력 첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.
두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.
세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.
출력 각 줄에 각 회의 승자를 출력합니다. 비겼을 경우는 D를 출력합니다.
 */
public class RockPaperScissors {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int games = Integer.valueOf(br.readLine());

        String[] a = br.readLine().split(" ");
        String[] b = br.readLine().split(" ");

        for (char x : solution(games, a, b).toCharArray()) {
            System.out.println(x);
        }

    }

    public static String solution(int games, String[] a, String[] b) {
        String answer = "";

        // 비기는 경우 / A가 이기는 모든 경우 / 나머지: B가 이기는 경우
        for (int i = 0; i < games; i++) {
            if (a[i].equals(b[i])) {
                answer += "D";
            } else if (a[i].equals("1") && b[i].equals("3")) {
                answer += "A";
            } else if (a[i].equals("2") && b[i].equals("1")) {
                answer += "A";
            } else if (a[i].equals("3") && b[i].equals("2")) {
                answer += "A";
            } else {
                answer += "B";
            }
        }

        return answer;
    }
}
