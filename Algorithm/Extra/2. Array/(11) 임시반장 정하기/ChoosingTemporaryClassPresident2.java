import java.io.*;
import java.util.StringTokenizer;

public class ChoosingTemporaryClassPresident2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // 0~5. 1~5
        int[][] students = new int[n+1][6];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= 5; j++) {
                students[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(String.valueOf(solution(n, students)));
        bw.flush();

        bw.close();
        br.close();
    }

    public static int solution(int n, int[][] students) {
        int answer = 0, max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= 5; k++) {
                    if (students[i][k] == students[j][k]) {
                        count++;
                        // 똑같을 경우 한 번만 카운트 해 줘야 한다
                        // ex) j학생이 i학생과 2학년 때 같은 반이고, 3학년 때 같은 반일 경우,
                        // j라는 학생을 한 번만 카운트.
                        break;
                    }
                }
            }
            if (count > max) {
                max = count;
                answer = i;
            }
        }

        return answer;
    }
}