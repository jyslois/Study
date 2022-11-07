/*
문제
N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다.
둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다.
모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.

출력
첫째 줄에 주어진 정수 N개의 최솟값과 최댓값을 공백으로 구분해 출력한다.
 */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BiggestAndSmallest_10818 {
    public static void main(String[] args) throws IOException {
//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
//        int[] num = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            num[i] = scan.nextInt();
//        }
//
//        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;
//
//        for (int x : num) {
//            if (x < min) {
//                min = x;
//            }
//            if (x > max) {
//                max = x;
//            }
//        }
//
//        System.out.print(min + " " + max);
//
//        scan.close();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int index = 0;
        while (st.hasMoreTokens()) {
            num[index++] = Integer.parseInt(st.nextToken());
        }

//        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;
//
//        for (int x : num) {
//            if (x < min) {
//                min = x;
//            }
//            if (x > max) {
//                max = x;
//            }
//        }
//
//        bw.write(min + " " + max);

        Arrays.sort(num);

        bw.write(num[0] + " " + num[n-1]);

        bw.flush();

        bw.close();
        br.close();
    }
}
