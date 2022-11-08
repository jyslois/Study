import java.io.*;

public class 별찍기2438 {
    public static void main(String[] args) throws IOException {
        // BufferedReader & BufferdWriter: https://snupi.tistory.com/48
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        br.close();

        String stars = "";

        for (int i = 0; i < N; i++) {
            bw.write(stars += "*");
            // 개행
            bw.newLine();
            // 모두 출력
            bw.flush();
        }

        bw.close();
    }
}
