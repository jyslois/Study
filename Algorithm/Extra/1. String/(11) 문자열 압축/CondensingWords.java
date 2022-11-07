import java.util.Scanner;

/*
알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
단 반복횟수가 1인 경우 생략합니다.
입력 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
출력 첫 줄에 압축된 문자열을 출력한다.
 */
public class CondensingWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String sen = scan.nextLine();
        sen = sen.toUpperCase();
        System.out.println(solution(sen));
    }

    public static String solution(String sen) {
        // 끝 글자는 공백과 비교
        sen += " ";

        String answer = "";
        int count = 1;

        // 빈문자 전까지만 - sen.length() - 1
        for (int i = 0; i < sen.length() - 1; i++) {
           if (sen.charAt(i) == sen.charAt(i + 1)) {
               count++;
           } else {
               answer += sen.charAt(i);
               if (count > 1) {
                   answer += String.valueOf(count);
                   count = 1;
               }
           }
        }
        return answer;
    }

}
