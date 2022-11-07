import java.util.*;

public class RemoveDuplicates {
    /*
소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.
첫 줄에 중복문자가 제거된 문자열을 출력합니다.
     */

    public static String solution(String sen) {
        String answer = "";

        for (int i = 0; i < sen.length(); i++) {
            // 중복되지 않는 글자는, 자신의 index 위치와 자신이 처음 발견되는 index위치가 같다.
            if (i == sen.indexOf(sen.charAt(i))) {
                answer += sen.charAt(i);
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String sen = scan.nextLine();

        System.out.println(solution(sen));
    }

}

/*
System.out.println(sen.charAt(i) + " > " + "인덱스: " + i + " 처음 발견 위치: " + sen.indexOf(sen.charAt(i)));
k > 인덱스: 0 처음 발견 위치: 0
s > 인덱스: 1 처음 발견 위치: 1
e > 인덱스: 2 처음 발견 위치: 2
k > 인덱스: 3 처음 발견 위치: 0
k > 인덱스: 4 처음 발견 위치: 0
s > 인덱스: 5 처음 발견 위치: 1
e > 인덱스: 6 처음 발견 위치: 2
t > 인덱스: 7 처음 발견 위치: 7
 */