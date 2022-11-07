/*
설명
대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로
소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.

입력
첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.

문자열은 영어 알파벳으로만 구성되어 있습니다.

출력
첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.
*/

import java.util.Scanner;

public class LetterConvert {
    public static String convert(String sen) {
        String result = "";
        for (char c : sen.toCharArray()) {
            if (Character.isUpperCase(c)) {
                c = Character.toLowerCase(c);
            } else {
                c = Character.toUpperCase(c);
            }
            result += c;
        }

        return result;

//        // 아스키넘버로 풀기: 대문자(65-90), 소문자(97-122): 소문자에서 -32하면 대문자가 된다.
//        for (char c: sen.toCharArray()) {
//            if (c >= 65 && c <= 90) { // 대문자이면
//                c = (char) (c + 32);
//            } else if (c >= 97 || c <= 122) {
//                c = (char) (c - 32);
//            }
//            result += c;
//        }
//        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String sen = scan.nextLine();
        System.out.println(convert(sen));
    }
}
