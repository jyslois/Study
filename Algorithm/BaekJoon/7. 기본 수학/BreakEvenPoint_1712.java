/*
문제
월드전자는 노트북을 제조하고 판매하는 회사이다. 노트북 판매 대수에 상관없이
매년 임대료, 재산세, 보험료, 급여 등 A만원의 고정 비용이 들며,
한 대의 노트북을 생산하는 데에는 재료비와 인건비 등 총 B만원의 가변 비용이 든다고 한다.

예를 들어 A=1,000, B=70이라고 하자. 이 경우 노트북을 한 대 생산하는 데는
총 1,070만원이 들며, 열 대 생산하는 데는 총 1,700만원이 든다.

노트북 가격이 C만원으로 책정되었다고 한다. 일반적으로 생산 대수를 늘려 가다 보면
어느 순간 총 수입(판매비용)이 총 비용(=고정비용+가변비용)보다 많아지게 된다.
최초로 총 수입이 총 비용보다 많아져 이익이 발생하는 지점을
손익분기점(BREAK-EVEN POINT)이라고 한다.

A, B, C가 주어졌을 때, 손익분기점을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 A, B, C가 빈 칸을 사이에 두고 순서대로 주어진다.
A, B, C는 21억 이하의 자연수이다.

출력
첫 번째 줄에 손익분기점 즉 최초로 이익이 발생하는 판매량을 출력한다.
손익분기점이 존재하지 않으면 -1을 출력한다.
 */

import java.io.*;
import java.util.StringTokenizer;

public class BreakEvenPoint_1712 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());  // 불변 비용
        int B = Integer.parseInt(st.nextToken());  // 가변 비용
        int C = Integer.parseInt(st.nextToken());  // 상품 가격

        int x = 0;

        // 비용과 총 수입이 같아지는 지점
        // (n * C) = A + (n * B)
        // (n * C) - (n * B) = A
        // n * (C - B) = A
        // n = A / (C - B)
        // 이익이 나는 지점이면 여기(n)에 1이 더해진 값, 즉 수식으로는 다음과 같다.
        // n = (A / (C - B)) + 1   이익이 나는 지점을 수식화.
        // (A / (C - B)) + 1 > 0   이 수식의 전제조건은 0보다 크고, 이는 이익이 발생한다는 의미이다.
        // 만약 이 수식이 음수가 된다면, 이익이 발생하지 않는다는 의미다.
        // A는 불변의 숫자이므로,
        // C - B < O  작으면, 이익이 발생하지 않는다. (C가격보다 B가 크면)
        // 또한 C - B = O이면 n 또한 무한대로 손익분기점이 발생하지 않게 된다.
        // 결론적으로 C - B <= O, 더 간단하게 하자면 C <= B. 이걸 만족하면
        // 이익이 발생하지 않는 조건이므로 -1을 출력하면 되고,
        // 이 외에는 (A / (C - B)) + 1의 연산 값을 출력해 주면 된다.

        if (C <= B) {
            bw.write("-1");
        } else {
            bw.write(String.valueOf((A/(C-B))+1));
        }

        bw.flush();

        br.close();
        bw.close();
    }
}
