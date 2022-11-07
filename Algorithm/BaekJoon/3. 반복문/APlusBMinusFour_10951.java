/*
문제
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

입력
입력은 여러 개의 테스트 케이스로 이루어져 있다.
각 테스트 케이스는 한 줄로 이루어져 있으며,
각 줄에 A와 B가 주어진다. (0 < A, B < 10)

출력
각 테스트 케이스마다 A+B를 출력한다.
 */

import java.io.*;
import java.util.StringTokenizer;

public class APlusBMinusFour_10951 {
    public static void main(String[] args) throws IOException {
//        // Scanner
//        Scanner scan = new Scanner(System.in);
//
//        // 어차피 입력이 들어오지 않기 때문에 hasNext()를 사용해도 가능
//        // 참고로 hasNextInt() 의 경우 입력값이 정수일경우 true를 반환하며
//        // 정수가 아닐경우 바로 예외를 던지며 더이상의 입력을 받지 않고
//        // hasNextInt()에서 false를 반환하면서 반복문이 종료된다.
//        // 앤터나 스페이스도 인식하기 때문에 control+d로
//        // 더이상 읽을 수 없는 데이터(EOF - End of File)가 없음을 알려주어야 한다.
//
//        while (scan.hasNextInt()) {
//            int a = scan.nextInt();
//            int b = scan.nextInt();
//            System.out.println(a+b);
//        }
//
//        scan.close();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String num;

        while ((num = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(num, " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(a+b));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
