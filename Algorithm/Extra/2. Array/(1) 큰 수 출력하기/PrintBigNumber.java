import java.util.ArrayList;
import java.util.Scanner;

/*
N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
(첫 번째 수는 무조건 출력한다)

입력 첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.
출력 자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.
 */

public class PrintBigNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();

        int[] list = new int[num];

        for (int i = 0; i < num; i++) {
            list[i] = scan.nextInt();
        }

        for (int n : solution(num, list)) {
            System.out.print(n + " ");
        }

    }

    public static ArrayList<Integer> solution(int num, int[] list) {
        ArrayList<Integer> answers = new ArrayList<>();

        // 첫번째 수는 무조건 출력한다
        answers.add(list[0]);

        for (int i = 1; i < num; i++) {
            if (list[i] > list[i - 1]) {
                answers.add(list[i]);
            }
        }

        return answers;
    }

}
