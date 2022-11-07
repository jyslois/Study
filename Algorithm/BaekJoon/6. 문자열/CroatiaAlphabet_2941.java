/*
문제
예전에는 운영체제에서 크로아티아 알파벳을 입력할 수가 없었다.
따라서, 다음과 같이 크로아티아 알파벳을 변경해서 입력했다.
(표)
예를 들어, ljes=njak은 크로아티아 알파벳 6개(lj, e, š, nj, a, k)로
이루어져 있다. 단어가 주어졌을 때, 몇 개의 크로아티아 알파벳으로 이루어져
있는지 출력한다.
dž는 무조건 하나의 알파벳으로 쓰이고, d와 ž가 분리된 것으로 보지 않는다.
lj와 nj도 마찬가지이다. 위 목록에 없는 알파벳은 한 글자씩 센다.

입력
첫째 줄에 최대 100글자의 단어가 주어진다. 알파벳 소문자와 '-', '='로만
이루어져 있다.
단어는 크로아티아 알파벳으로 이루어져 있다. 문제 설명의 표에 나와있는
알파벳은 변경된 형태로 입력된다.

출력
입력으로 주어진 단어가 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
 */

import java.io.*;

public class CroatiaAlphabet_2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String sen = br.readLine();

        int count = 0;

        for (int i = 0; i < sen.length(); i++) {
            // sen.length() - 1보다 작을 때만 검사
            // ch= 또는 ch-일 경우
            if (sen.charAt(i) == 'c' && i < sen.length() - 1) {
                // sen.length() - 1보다 작을 때만 검사
                if (sen.charAt(i + 1) == '=' || sen.charAt(i + 1) == '-') {
                    i++;
                }
            // d- 또는 dz=일 경우
            } else if (sen.charAt(i) == 'd' && i < sen.length() - 1) {
                if (sen.charAt(i + 1) == '-') {
                    i++;
                // dz=일 경우 i < sen.length() - 2 보다 작을 때만 검사
                } else if (sen.charAt(i + 1) == 'z' && i < sen.length() - 2) {
                    if (sen.charAt(i + 2) == '=') {
                        i += 2;
                    }
                }
            // lj 또는 nj일 경우
            } else if ((sen.charAt(i) == 'l' || sen.charAt(i) == 'n') && i < sen.length() - 1) {
                if (sen.charAt(i + 1) == 'j') {
                    i++;
                }
            // s= 또는 z=일 경우
            } else if ((sen.charAt(i) == 's' || sen.charAt(i) == 'z') && i < sen.length() - 1) {
                if (sen.charAt(i + 1) == '=') {
                    i++;
                }
            }

            count++;

        }

        bw.write(String.valueOf(count));
        bw.flush();

        br.close();
        bw.close();
    }
}