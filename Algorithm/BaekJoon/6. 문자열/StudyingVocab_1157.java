/*
문제
알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이
무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.

입력
첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의
길이는 1,000,000을 넘지 않는다.

출력
첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다.
단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
 */

import java.util.Scanner;

public class StudyingVocab_1157 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String word = scan.nextLine();

        word = word.toUpperCase();

        // count를 세기 위한 배열. 알파벳은 A-Z 26가지가 있다.
        int[] alphabets = new int[26];

        for (int i = 0; i < word.length(); i++) {
            // A-Z는 65부터 90까지다. A는 인덱스 0.
            alphabets[word.charAt(i) - 65]++;
        }

        // 가장 큰 값을 가지고 있는 인덱스의 문자 출력하기
        int max = 0;
        char answer = '?';
        for (int i = 0; i < alphabets.length; i++) {
            if (alphabets[i] > max) {
                max = alphabets[i];
                answer = (char) (i + 65); // 대문자로 출력해야 하므로 65를 더해준다. 0이 A다.
            } else if (alphabets[i] == max) {
                answer = '?';
            }
        }

        System.out.println(answer);

    }
}
