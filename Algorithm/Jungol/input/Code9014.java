import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Code9014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("당신의 나이는 몇 살입니까? ");
        int a = Integer.parseInt(br.readLine());

        System.out.printf("당신의 나이는 %d살이군요.", a);

    }
}
