/*
설명
한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가
입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.
대소문자를 구분하지 않습니다.문자열의 길이는 100을 넘지 않습니다.

입력
첫 줄에 문자열이 주어지고, 두 번째 줄에 문자가 주어진다.
문자열은 영어 알파벳으로만 구성되어 있습니다.

출력
첫 줄에 해당 문자의 개수를 출력한다.
 */

import java.util.Scanner;

public class NumOfChar {
    static int solution(String sen, char chr) {
        int char_num = 0;
        sen = sen.toUpperCase(); // 일단 대문자나 소문자 중 하나로 통일해 준다 (대소문자 구분 없기 위해)
        chr = Character.toUpperCase(chr); // 문자이기에 Character클래스의 메서드 사용

//        for (char t : sen.toCharArray()) { // 1) 문자열을 문자 배열로 만들어 비교하는 방법 (for-each는 배열만 들어간다, String은 안 됨)
//            if (t == chr) {
//                char_num++;
//            }
//        }

        for (int i = 0; i < sen.length(); i++) { // 2) 문자열에서 for문으로 문자 하나씩을 chr과 비교하는 방법
            if (sen.charAt(i) == chr) {
                char_num++;
            }
        }

        return char_num;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String sen = scan.nextLine();

        char chr = scan.nextLine().charAt(0); // 문자열에서 첫번째 문자만 뽑아 변수에 저장

        // solution이 static method로 만들었기 때문에 같은 클래스 내에선 객체 생성 없이 사용 가능하다.
        System.out.println(solution(sen, chr));
    }

}