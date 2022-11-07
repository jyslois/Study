/*
문제
본격적으로 for문 문제를 풀기 전에 주의해야 할 점이 있다.
입출력 방식이 느리면 여러 줄을 입력받거나 출력할 때 시간초과가 날 수 있다는 점이다.

Java를 사용하고 있다면, Scanner와 System.out.println 대신 BufferedReader와
BufferedWriter를 사용할 수 있다. BufferedWriter.flush는 맨 마지막에 한 번만 하면 된다.

또한 입력과 출력 스트림은 별개이므로,
테스트케이스를 전부 입력받아서 저장한 뒤 전부 출력할 필요는 없다.
테스트케이스를 하나 받은 뒤 하나 출력해도 된다.
자세한 설명 및 다른 언어의 경우는 이 글에 설명되어 있다.
이 블로그 글에서 BOJ의 기타 여러 가지 팁을 볼 수 있다.

입력
첫 줄에 테스트케이스의 개수 T가 주어진다. T는 최대 1,000,000이다.
다음 T줄에는 각각 두 정수 A와 B가 주어진다. A와 B는 1 이상, 1,000 이하이다.

출력
각 테스트케이스마다 A+B를 한 줄에 하나씩 순서대로 출력한다.
 */
import java.io.*;

public class FastAPlusB_15552 {
    // Scanner 대신 BufferedReader을, System.out.print() 대신 BufferedWriter 사용하기.
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] nums = br.readLine().split(" ");
            // write()에는 자동 개행이 없어 + "\n" 을 붙여 주어야 한다.
            // write()을 사용하여 출력할 내용을 담는다
            bw.write((Integer.parseInt(nums[0]) + Integer.parseInt(nums[1])) + "\n");
        }

        // flush()를 통해서 버퍼를 비워내는 동시에 콘솔에 출력한다
        bw.flush();

        br.close();
        bw.close();
    }
}
