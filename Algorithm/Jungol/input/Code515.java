import java.io.*;
import java.util.StringTokenizer;

public class Code515 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(a + " * " + b + " = " + a*b);
        bw.newLine();
        bw.write(a + " / " + b + " = " + a/b);
        bw.flush();
        bw.close();
        br.close();

    }
}
