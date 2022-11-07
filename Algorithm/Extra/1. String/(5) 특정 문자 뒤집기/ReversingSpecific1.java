import java.util.*;

public class ReversingSpecific1 {
    // 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
    // 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
    // 첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.
    // 첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.

    public static String solution(String sen) {
        String answer;
        char[] tmp = sen.toCharArray();

        int left = 0, right = sen.length() - 1;

        while (left < right) {
            // left가 특수문자면 (알파벳이 아니면) left증가
            if (!Character.isAlphabetic(tmp[left])) {
                left++;
            } else if(!Character.isAlphabetic(tmp[right])) {
                // left가 알파벳이고, right가 특수문자이면 right감소
                right--;
            } else { // 둘 다 알파벳이면, 바꾸고 left증가, right감소
                char tem = tmp[left];
                tmp[left] = tmp[right];
                tmp[right] = tem;

                left++;
                right--;
            }

        }

        answer = String.valueOf(tmp);

        return answer;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String sen = scan.nextLine();

        for (char word : solution(sen).toCharArray()) {
            System.out.print(word);
        }
    }
}