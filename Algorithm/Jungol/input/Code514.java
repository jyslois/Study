import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Code514 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("height = ");
        String height = br.readLine();

        System.out.printf("Your height is %scm.", height);

    }
}
