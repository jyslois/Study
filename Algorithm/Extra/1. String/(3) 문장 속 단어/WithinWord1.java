// 한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
// 문장속의 각 단어는 공백으로 구분됩니다. Ex) it is time to study => study
// 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한 단어를 답으로 한다.

import java.util.*;

public class WithinWord1 {
    // 1. String의 split()메서드 사용

    public static String solution(String sen) {
        int max_length = Integer.MIN_VALUE;

        String answer = "";
        String[] senArr = sen.split(" ");
        // Arrays.toString(senArr) => [it, is, time, to, study]

        for (String word : senArr) {
            int len = word.length();
            if (len > max_length) {
                max_length = len;
                answer = word;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

//        String sen;
//        outer: while (true) {
//            sen = scan.nextLine();
//            char[] s = sen.toCharArray();
//            for (char ch : s) {
//                // 대문자(65-90), 소문자(97-122)
//                if (!(ch >= 65 && ch <= 90) && !(ch >= 97 && ch <= 122) && ch != ' ') {
//                    continue outer;
//                }
//            }
//            System.out.print(solution(sen));
//            break;

        String sen = scan.nextLine();
        System.out.println(solution(sen));

    }

}

